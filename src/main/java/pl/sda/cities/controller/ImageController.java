package pl.sda.cities.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.sda.cities.entity.City;
import pl.sda.cities.entity.Image;
import pl.sda.cities.repository.CityRepository;
import pl.sda.cities.repository.ImageRepository;

@Controller
@RequestMapping("/image")
public class ImageController {
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addImage(ModelMap model) {
		model.addAttribute("cities", cityRepository.findAll());
		return "image/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void handleAddImage(@RequestParam("name") String name,
								@RequestParam("url") String url,
								@RequestParam("city") long cityId,
								HttpServletRequest req, HttpServletResponse res) throws IOException {
		City city = cityRepository.findOne(cityId);
		Image image = new Image(name, url, city);
		imageRepository.save(image);
		res.sendRedirect(req.getContextPath() + "/image/all");
	}
	
	@RequestMapping("/all")
	public String showAll(ModelMap model) {
		model.addAttribute("images", imageRepository.findAll());
		return "image/all";
	}
	
	@RequestMapping("/show/{id}")
	public String showOne(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("image", imageRepository.findOne(id));
		return "image/show";
	}
	
	@RequestMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id, HttpServletRequest req, HttpServletResponse res) throws IOException {
		Image image = imageRepository.findOne(id);
		image.getCity().getImages().remove(image);
		imageRepository.save(image);
		imageRepository.delete(image);
		res.sendRedirect(req.getContextPath() + "/image/all");
	}
	
}
