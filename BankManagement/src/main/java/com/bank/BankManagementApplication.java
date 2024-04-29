package com.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bank.mappers.UtilisateurMapper;
import com.bank.model.entities.Utilisateur;

import com.bank.services.UtilisateurService;

@SpringBootApplication
public class BankManagementApplication implements CommandLineRunner{
	
	@Autowired
	UtilisateurService utilisateurService;

	public static void main(String[] args) {
		SpringApplication.run(BankManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//utilisateurService.addOneUtilisateur(UtilisateurMapper.convertToDTO(new Utilisateur("khalil","khalil@gmail.com", "azerty", null, null, "ADMIN_ROLES,USER_ROLES")));

	}

}
