package pl.sda.cities.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.sda.cities.entity.CityDescription;

@Repository
public interface CityDescriptionRepository extends CrudRepository<CityDescription, Long> {

}
