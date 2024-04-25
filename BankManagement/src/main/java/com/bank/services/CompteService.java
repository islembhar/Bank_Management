package com.bank.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bank.model.dto.CompteDto;


public interface CompteService {
public Page<CompteDto> getAllComptes(Pageable pageable);
public void deleteOne(long id);
public CompteDto getCompteById(long id);

}
