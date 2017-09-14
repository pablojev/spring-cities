package pl.sda.cities.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CityDescription {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	private String president;
	private float area;
	private int year;
	private double averageSalary;
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	private City city;
	
	public CityDescription() { }

	public CityDescription(String president, float area, int year, double averageSalary, City city) {
		this.president = president;
		this.area = area;
		this.year = year;
		this.averageSalary = averageSalary;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getAverageSalary() {
		return averageSalary;
	}

	public void setAverageSalary(double averageSalary) {
		this.averageSalary = averageSalary;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
}
