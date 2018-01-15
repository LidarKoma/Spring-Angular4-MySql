package com.example.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Country {
	public Country() {}
	
	
	String name;
	@Id 
	String code;
	
	

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@OneToMany( mappedBy = "country")
	private Set<States> states;
	
	public Set<States> getStates() {
		return states;
	}
	public void setStates(Set<States> states) {
		this.states = states;
	}

}
