package com.bank.mappers;

import org.modelmapper.ModelMapper;

import com.bank.model.dto.CompteDto;
import com.bank.model.dto.ProfileDto;
import com.bank.model.entities.Compte;
import com.bank.model.entities.Profile;

public class ProfileMapper {
	private static final ModelMapper modelMapper= new ModelMapper();
	public static ProfileDto convertToDTO(Profile profile)
	{
	return modelMapper.map(profile, ProfileDto.class);
	}

	public static Profile convertToEntity(ProfileDto profileDTO)
	{
	return modelMapper.map(profileDTO, Profile.class);	
	}
}