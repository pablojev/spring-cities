package pl.sda.cities.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	private String name;
	@JsonBackReference
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "country", cascade = CascadeType.ALL)
	private List<City> listOfCities = new LinkedList<>();
	
	public Country() {}

	public Country(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getListOfCities() {
		return listOfCities;
	}

	public void setListOfCities(List<City> listOfCities) {
		this.listOfCities = listOfCities;
	}
	
	
	
}
