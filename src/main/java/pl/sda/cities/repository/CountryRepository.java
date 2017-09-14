package pl.sda.cities.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.sda.cities.entity.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

}
