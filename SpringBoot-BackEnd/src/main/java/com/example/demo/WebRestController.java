package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Country;
import com.example.demo.model.States;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.StatesRepository;
 
@RestController
@CrossOrigin(origins = {"*"})
public class WebRestController {
	@Autowired
	CountryRepository r;
	
	@Autowired
	StatesRepository s;
	
	@RequestMapping("/api")
	public String index1() {
		return "add this to herokues";
}
	
@GetMapping(value="/api/getCountries",  produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Country>> getCountries() {
	List<Country> list = r.findAll();
	

	//List<Country> list = r.findAll();
	return new ResponseEntity<List<Country>>(list, HttpStatus.OK);
	}
	
	
// or @RequestMapping(value="/api/getCountry",params = "code",
//produces=MediaType.APPLICATION_JSON_VALUE)
@GetMapping(value="/api/getCountry",params = "code",produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Country> getCountry(@RequestParam("code") String code) {
	Country list = r.findByCode(code);
	return new ResponseEntity<Country>(list, HttpStatus.OK);
}	



/*@GetMapping(value="/api/addState",params = "code",produces=MediaType.APPLICATION_JSON_VALUE)
public int addState(@RequestBody States states) {
	Country list = r.findByCode(states.getCode());
	
	return list.getId();
}*/




//@PostMapping(value="/api/addState")
//public void addState(@RequestBody String code, @RequestBody String state) {
@PostMapping(value="/api/addState",produces=MediaType.APPLICATION_JSON_VALUE)
public void addStates(@RequestBody MultiValueMap<String, String> name, @RequestBody MultiValueMap<String, String> code)  {
	//String n=name.getFirst("name");
	//String c= code.getFirst("code");
	Country country = new Country();
	  
	country.setCode(code.getFirst("code"));


	
  
  States states = new States();
  states.setName(name.getFirst("name")); //Get
 // states.setName(state);//Post
states.setCountry(country);
s.save(states);
}


}