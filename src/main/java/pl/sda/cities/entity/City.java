package pl.sda.cities.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	private String name;
	private String zip;
	private float population;
	@Column(length = 65535, columnDefinition = "text")
	private String description;
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "city", cascade = CascadeType.ALL)
	private List<Image> images;
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Country country; 
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Attraction> attractions;
	@OneToOne(mappedBy = "city", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private CityDescription cityDescription;
	
	public City() {}
	
	public City(String name, String zip, float population, String description) {
		this.name = name;
		this.zip = zip;
		this.population = population;
		this.description = description;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public float getPopulation() {
		return population;
	}
	public void setPopulation(float population) {
		this.population = population;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<Attraction> getAttractions() {
		return attractions;
	}

	public void setAttractions(Set<Attraction> attractions) {
		this.attractions = attractions;
	}

	public CityDescription getCityDescription() {
		return cityDescription;
	}

	public void setCityDescription(CityDescription cityDescription) {
		this.cityDescription = cityDescription;
	}
	
	
}
