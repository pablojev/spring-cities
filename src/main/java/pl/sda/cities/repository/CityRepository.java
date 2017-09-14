package pl.sda.cities.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.sda.cities.entity.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}
