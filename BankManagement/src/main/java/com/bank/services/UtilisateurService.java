package com.bank.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bank.model.dto.CompteDto;
import com.bank.model.dto.ProfileDto;
import com.bank.model.dto.UtilisateurDto;
import com.bank.model.entities.Profile;

public interface UtilisateurService {
	public UtilisateurDto addOneUtilisateur(UtilisateurDto utilisateurDto);
	public Page<UtilisateurDto> getAllUtilisateur(Pageable pageable );
	public Optional<UtilisateurDto> getOneUtilisateur(long id);
	public void deleteOneUtilisateur(long id);
	public ProfileDto assignProfileToUtilisateur(long idUser,Profile ProfileDto);
	 public UtilisateurDto assignCompteToUtilisateur(long idUser, CompteDto compteDto);
	 public UtilisateurDto findByComptes(long idCompte);

}
