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

import pl.sda.cities.entity.Attraction;
import pl.sda.cities.repository.AttractionRepository;

@Controller
@RequestMapping("/attraction")
public class AttractionController {
	@Autowired
	AttractionRepository attractionRepository;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm() {
		return "attraction/addEdit";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void handleAddCountry(@RequestParam("name") String name,
								HttpServletRequest req, HttpServletResponse res) throws IOException {
		Attraction attraction = new Attraction(name);
		attractionRepository.save(attraction);
		res.sendRedirect(req.getContextPath() + "/attraction/all");
	}
	
	@RequestMapping("/all")
	public String all(ModelMap model) {
		model.addAttribute("attractions", attractionRepository.findAll());
		return "attraction/all";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("attraction", attractionRepository.findOne(id));
		return "attraction/addEdit";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public void editForm(@PathVariable("id") long id, 
							@RequestParam("name") String name,
							ModelMap model,
							HttpServletRequest req, HttpServletResponse res) throws IOException {
		Attraction attraction = attractionRepository.findOne(id);
		attraction.setName(name);
		attractionRepository.save(attraction);
		res.sendRedirect(req.getContextPath() + "/attraction/all");
	}
	
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id,
						HttpServletRequest req, HttpServletResponse res) throws IOException {
		attractionRepository.delete(id);
		res.sendRedirect(req.getContextPath() + "/attraction/all");
	}
}
