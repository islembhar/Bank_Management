package com.bank.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bank.mappers.CompteMapper;
import com.bank.model.dto.CompteDto;
import com.bank.model.entities.Compte;
import com.bank.repository.CompteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompteServiceImp implements CompteService {

	private final CompteRepository compteRepository;
	
	
	@Override
	public Page<CompteDto> getAllComptes(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Compte> comptes=compteRepository.findAll(pageable);
		return comptes.map(CompteMapper::convertToDTO);
	}

	@Override
	public void deleteOne(long id) {
		// TODO Auto-generated method stub
		compteRepository.deleteById(id);

	}

	@Override
	public CompteDto getCompteById(long id) {
		// TODO Auto-generated method stub
		return compteRepository.findById(id).map(CompteMapper::convertToDTO).orElse(null);
	}

}