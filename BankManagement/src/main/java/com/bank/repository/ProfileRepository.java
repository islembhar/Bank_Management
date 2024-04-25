package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.model.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
