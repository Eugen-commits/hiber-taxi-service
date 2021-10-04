package ru.digitalleague.hibertaxiservice.persistance.repository;

import org.springframework.data.repository.CrudRepository;
import ru.digitalleague.hibertaxiservice.persistance.entity.CityQueue;

public interface CityQueueRepository extends CrudRepository<CityQueue, Long> {
}
