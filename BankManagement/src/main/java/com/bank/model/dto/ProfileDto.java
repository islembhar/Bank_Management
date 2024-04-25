package com.bank.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)

public class ProfileDto  {
	@Size(min = 8,max = 16)
	private String phoneNumber;
	
	private String adresse;
	@JsonIgnoreProperties("profile")

	private UtilisateurDto utilisateur; 
}
