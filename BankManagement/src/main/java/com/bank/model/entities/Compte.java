package com.bank.model.entities;

import java.math.BigDecimal;
import java.util.List;

import com.bank.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class Compte extends BaseEntity {
	private double solde;
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	
	private Utilisateur utilisateur;
	@OneToMany(mappedBy = "source")
	
	private List<Transaction> transactions;

}
