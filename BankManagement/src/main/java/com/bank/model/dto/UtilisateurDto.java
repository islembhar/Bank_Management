package com.bank.model.dto;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data

@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)

public class UtilisateurDto extends BaseDto {
	@NotBlank
	private String nom;
	@NotBlank
	@Email
	private String email;
	
	@JsonIgnoreProperties(allowSetters  = true,value="password")
	@NotBlank
	@Size(min = 8)
	private String password;
	@JsonIgnoreProperties("utilisateur")
	private List<CompteDto> comptes;

	@JsonIgnoreProperties("utilisateur")

	private ProfileDto profile;
	private String roles;
	
	
	
}