package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.States;

public interface StatesRepository extends JpaRepository<States, Long> {
	//List<States> findByCountry_id(int i);
	//States insertByStates_

	States save(States states);

}
