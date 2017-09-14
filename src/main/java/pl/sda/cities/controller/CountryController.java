package pl.sda.cities.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.sda.cities.entity.Country;
import pl.sda.cities.repository.CountryRepository;

@Controller
@RequestMapping("/country")
public class CountryController {
	@Autowired
	CountryRepository countryRepository;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm() {
		return "country/addEdit";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void handleAddCountry(@RequestParam("name") String name,
								HttpServletRequest req, HttpServletResponse res) throws IOException {
		Country country = new Country(name);
		countryRepository.save(country);
		res.sendRedirect(req.getContextPath() + "/country/all");
	}
	
	@RequestMapping("/all")
	public String all(ModelMap model) {
		model.addAttribute("countries", countryRepository.findAll());
		return "country/all";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("country", countryRepository.findOne(id));
		return "country/addEdit";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public void editForm(@PathVariable("id") long id, 
							@RequestParam("name") String name,
							ModelMap model,
							HttpServletRequest req, HttpServletResponse res) throws IOException {
		Country country = countryRepository.findOne(id);
		country.setName(name);
		countryRepository.save(country);
		res.sendRedirect(req.getContextPath() + "/country/all");
	}
	
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id,
						HttpServletRequest req, HttpServletResponse res) throws IOException {
		countryRepository.delete(id);
		res.sendRedirect(req.getContextPath() + "/country/all");
	}
}
