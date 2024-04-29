package com.bank.services.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bank.model.entities.Utilisateur;
import com.bank.repository.UtilisateurRepository;

import lombok.RequiredArgsConstructor;
@Service
public class UserInfoService  implements UserDetailsService{

	@Autowired
	private UtilisateurRepository userInfoRepository;
	
	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<Utilisateur> userInfo = userInfoRepository.findByEmail(username);
	        return userInfo.map(UserInfoDetails::new)
	                .orElseThrow(()-> new UsernameNotFoundException("User not found"+username));
	    }
}
