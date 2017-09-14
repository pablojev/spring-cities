package pl.sda.cities.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.sda.cities.entity.Attraction;
import pl.sda.cities.entity.City;
import pl.sda.cities.entity.CityDescription;
import pl.sda.cities.entity.Country;
import pl.sda.cities.repository.AttractionRepository;
import pl.sda.cities.repository.CityDescriptionRepository;
import pl.sda.cities.repository.CityRepository;
import pl.sda.cities.repository.CountryRepository;

@Controller
@RequestMapping("/city")
public class CityController {
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	CityDescriptionRepository cityDescriptionRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	AttractionRepository attractionRepository;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(ModelMap model) {
		model.addAttribute("countries", countryRepository.findAll());
		return "city/addEdit";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void handleAddForm(@RequestParam("name") String name,
								@RequestParam("zip") String zip,
								@RequestParam("population") float population,
								@RequestParam("description") String description,
								@RequestParam("country") long countryId,
								@RequestParam("president") String president,
								@RequestParam("area") float area,
								@RequestParam("year") int year,
								@RequestParam("averageSalary") double averageSalary,
								HttpServletRequest req, HttpServletResponse res) throws IOException {
		City city = new City(name, zip, population, description);
		
		CityDescription cityDescription = new CityDescription(president, area, year, averageSalary, city);
		city.setCityDescription(cityDescription);
		
		Country country = countryRepository.findOne(countryId);
		country.getListOfCities().add(city);
		
		countryRepository.save(country);
		res.sendRedirect(req.getContextPath() + "/city/all");
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") long id, ModelMap model) {
		City city = cityRepository.findOne(id);
		model.addAttribute("city", city);
		model.addAttribute("countries", countryRepository.findAll());
		model.addAttribute("attractions", attractionRepository.findAll());
		return "city/addEdit";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public void handleEditForm(@PathVariable("id") long id, 
								@RequestParam("name") String name,
								@RequestParam("zip") String zip,
								@RequestParam("population") float population,
								@RequestParam("description") String description,
								@RequestParam("country") long countryId,
								@RequestParam("president") String president,
								@RequestParam("area") float area,
								@RequestParam("year") int year,
								@RequestParam("averageSalary") double averageSalary,
								@RequestParam(value = "attractions", required = false) Long[] attractions,
								HttpServletRequest req, HttpServletResponse res) throws IOException {
		City city = cityRepository.findOne(id);
		city.setName(name);
		city.setZip(zip);
		city.setPopulation(population);
		city.setDescription(description);
		
		CityDescription cityDescription = city.getCityDescription();
		cityDescription.setPresident(president);
		cityDescription.setArea(area);
		cityDescription.setYear(year);
		cityDescription.setAverageSalary(averageSalary);
		cityDescription.setCity(city);
		
		city.setCityDescription(cityDescription);
		city.setAttractions(null);
		cityRepository.save(city);
		
		Set<Attraction> setOfAttractions = new HashSet<>();
		if(attractions != null) {
			for(long attractionId: attractions) {
				setOfAttractions.add(attractionRepository.findOne(attractionId));
			}
		}
		
		city.setAttractions(setOfAttractions);
		
		cityRepository.save(city);
		res.sendRedirect(req.getContextPath() + "/city/all");
	}
	
	@RequestMapping("/all")
	public String showAll(ModelMap model) {
		List<City> listOfCities = (List<City>) cityRepository.findAll();
		model.addAttribute("cities", listOfCities);
		model.addAttribute("attractions", attractionRepository.findAll());
		return "city/all";
	}
	
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id,
						HttpServletRequest req, HttpServletResponse res) throws IOException {
		City city = cityRepository.findOne(id);
		
		CityDescription cityDescription = city.getCityDescription();
		cityDescription.setCity(null);
		cityDescriptionRepository.save(cityDescription);
		
		city.setAttractions(null);
		city.setCountry(null);
		city.setCityDescription(null);
		
		cityRepository.save(city);
		cityRepository.delete(id);
		res.sendRedirect(req.getContextPath() + "/city/all");
	}
	
	@RequestMapping("/show/{id}")
	public String showCity(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("city", cityRepository.findOne(id));
		model.addAttribute("attractions", attractionRepository.findAll());
		return "city/show";
	}
}
