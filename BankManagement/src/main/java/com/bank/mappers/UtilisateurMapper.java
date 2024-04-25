package com.bank.mappers;

import org.modelmapper.ModelMapper;

import com.bank.model.dto.UtilisateurDto;
import com.bank.model.entities.Utilisateur;

public class UtilisateurMapper {
	private static final ModelMapper modelMapper= new ModelMapper();
	public static UtilisateurDto convertToDTO(Utilisateur utilisateur)
	{
	return modelMapper.map(utilisateur, UtilisateurDto.class);
	}

	public static Utilisateur convertToEntity(UtilisateurDto utilisateurDTO)
	{
	return modelMapper.map(utilisateurDTO, Utilisateur.class);	
	}

}
