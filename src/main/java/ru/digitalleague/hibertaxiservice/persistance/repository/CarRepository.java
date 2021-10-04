package ru.digitalleague.hibertaxiservice.persistance.repository;


import org.springframework.data.repository.CrudRepository;
import ru.digitalleague.hibertaxiservice.persistance.entity.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
    Car findByModel(String model);
}
