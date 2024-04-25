package com.bank.model.entities;

import java.math.BigDecimal;

import com.bank.model.BaseEntity;
import com.bank.model.Types;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
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
@JsonIgnoreProperties({"hibernateLazyInitialiser","handler"})
public class Transaction extends BaseEntity {

private double montant;
@Enumerated(EnumType.STRING)
private Types type;
@ManyToOne(optional = true,fetch = FetchType.EAGER)
private Compte source;
@ManyToOne(optional = true,fetch = FetchType.EAGER)
private Compte destination;

}
