package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import com.bank.model.entities.Compte;
import com.bank.model.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
Utilisateur findByComptes(List<Compte> comptes);
Optional <Utilisateur> findByEmail(String email);

}
