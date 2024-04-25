package com.bank.model.dto;

import java.math.BigDecimal;

import com.bank.model.Types;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
//@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)

public class TransactionDto extends BaseDto {
	@Positive
	private BigDecimal montant;
	
	private Types type;
	@JsonIgnoreProperties("transactions")
	private CompteDto source;
	@JsonIgnoreProperties("transactions")

	private CompteDto destination;



}
