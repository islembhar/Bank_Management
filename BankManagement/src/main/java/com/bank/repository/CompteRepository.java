package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

}
