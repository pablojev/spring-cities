package pl.sda.cities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.sda.cities.entity.City;
import pl.sda.cities.repository.CityRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/city")
public class RestCityController {
	
	@Autowired
	CityRepository cityRepository;

	@RequestMapping("/show/{id}")
	public City showCityById(@PathVariable("id") long id) {
		return cityRepository.findOne(id);
	}
}
