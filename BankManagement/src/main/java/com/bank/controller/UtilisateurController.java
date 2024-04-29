	package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bank.model.dto.AuthRequest;
import com.bank.model.dto.CompteDto;
import com.bank.model.dto.ProfileDto;
import com.bank.model.dto.TransactionDto;
import com.bank.model.dto.UtilisateurDto;
import com.bank.model.entities.Profile;
import com.bank.services.UtilisateurService;
import com.bank.services.UtilisateurServiceImp;
import com.bank.services.auth.JwtService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/utilisateurs") 
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurServiceImp utilisateurService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @PostMapping
    public ResponseEntity<UtilisateurDto> addUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
        UtilisateurDto createdUtilisateur = utilisateurService.addOneUtilisateur(utilisateurDto);
        return new ResponseEntity<>(createdUtilisateur, HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN_ROLES')")
    public ResponseEntity<Page<UtilisateurDto>> getAllUtilisateurs(Pageable pageable) {
        Page<UtilisateurDto> utilisateurs = utilisateurService.getAllUtilisateur(pageable);
        return ResponseEntity.ok(utilisateurs);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER_ROLES')")

    public ResponseEntity<UtilisateurDto> getUtilisateurById(@PathVariable long id) {
        return utilisateurService.getOneUtilisateur(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest){
        try {
            Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
            if(authenticate.isAuthenticated()){
                return ResponseEntity.ok(jwtService.generateToken(authRequest.getUserName()));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user request");
        }
    }
    
    @GetMapping("/{id}/comptes")
    public ResponseEntity<UtilisateurDto> getUserByComptes(@PathVariable long id)
    {
    	return ResponseEntity.ok(utilisateurService.findByComptes(id));
    }
    
    

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN_ROLES')")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable long id) {
        utilisateurService.deleteOneUtilisateur(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idUser}/profile")
    public ResponseEntity<ProfileDto> assignProfileToUtilisateur(@PathVariable long idUser, @RequestBody Profile profile) {
        try {
            ProfileDto profileDto = utilisateurService.assignProfileToUtilisateur(idUser, profile);
            return ResponseEntity.ok(profileDto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{idUser}/compte")
    public ResponseEntity<UtilisateurDto> assignCompteToUtilisateur(@PathVariable long idUser, @RequestBody CompteDto compteDto) {
        try {
            UtilisateurDto utilisateurDto = utilisateurService.assignCompteToUtilisateur(idUser, compteDto);
            return ResponseEntity.ok(utilisateurDto);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }


}