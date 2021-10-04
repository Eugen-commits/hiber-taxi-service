package ru.digitalleague.hibertaxiservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digitalleague.hibertaxiservice.persistance.entity.CityQueue;
import ru.digitalleague.hibertaxiservice.persistance.repository.CityQueueRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CityQueueService {
    @Autowired
    private CityQueueRepository cityQueueRepository;

    public void createCityQueue(CityQueue cityQueue){
        log.info("New CityQueue is - " + cityQueue.toString());
        cityQueueRepository.save(cityQueue);
    }
    public List<CityQueue> getAllQueue(){
        List<CityQueue> allCityQueue = new ArrayList<>();
        cityQueueRepository.findAll().iterator().forEachRemaining(allCityQueue::add);
        return allCityQueue;
    }
    public CityQueue getById(Long id){
        return cityQueueRepository.findById(id).orElseThrow(RuntimeException::new);
    }
    public void deleteById(Long id){
        cityQueueRepository.deleteById(id);
    }
    public void updateCityQueue(CityQueue cityQueue){
        String oldcityQueue = getById(cityQueue.getCity_id()).toString();
        cityQueueRepository.save(cityQueue);
        log.info("old cityQueue is " + oldcityQueue + " " + "new car is - " + cityQueue);
    }
}
