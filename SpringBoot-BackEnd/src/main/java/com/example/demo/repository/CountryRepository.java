package com.example.demo.repository;
import com.example.demo.model.Country;
import com.example.demo.model.States;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
	Country findByCode(String code);

	
}
