package com.bank.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.dto.CompteDto;
import com.bank.services.CompteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("comptes")
@RequiredArgsConstructor
public class ComptesController {
	
	private final CompteService compteService;
	
    @GetMapping("/{id}")
public ResponseEntity<CompteDto> findOneCompte(@PathVariable long id)
{
    	
return ResponseEntity.ok(compteService.getCompteById(id));
}
@GetMapping
public ResponseEntity<Page<CompteDto>> findAll(Pageable pageable)
{
return ResponseEntity.ok(compteService.getAllComptes(pageable));	

}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteCompte(@PathVariable long id)
{
compteService.deleteOne(id);
return ResponseEntity.noContent().build();
}


}
