package pl.sda.cities.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.sda.cities.entity.Attraction;

@Repository
public interface AttractionRepository extends CrudRepository<Attraction, Long> {

}
