package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class States {
	public States() {}
	
	@Id 
	String name;
	
	
	
	
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	
	//public String getCode() {
	//return code;
    //}
	//public void setCode(String code) {
	//this.code = code;
	//}
	
	@ManyToOne()
	@JoinColumn(name = "country_code")
	@JsonBackReference
	
	private Country country;
	
	public Country getCountry() {
	return country;
	}
	public void setCountry(Country country) {
	this.country = country;
	}

}

