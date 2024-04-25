package com.bank.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)

public class CompteDto extends BaseDto {
	@NotNull
	private double solde;
	@JsonIgnoreProperties("comptes")

	private UtilisateurDto utilisateur;
	@JsonIgnoreProperties({"source","destination"})
	

	private List<TransactionDto> transactions;
}