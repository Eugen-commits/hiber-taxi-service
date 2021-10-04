package ru.digitalleague.hibertaxiservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.hibertaxiservice.persistance.entity.CityQueue;
import ru.digitalleague.hibertaxiservice.service.CityQueueService;

import java.util.List;

@Controller
@RequestMapping("/queue")
public class CityQueueController {
    @Autowired
    private CityQueueService cityQueueService;

    @GetMapping("/all")
    public ResponseEntity<List<CityQueue>> getAll(){
       return new ResponseEntity<>(cityQueueService.getAllQueue(), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createCityQueue(@RequestBody CityQueue cityQueue){
        cityQueueService.createCityQueue(cityQueue);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<CityQueue> updateCityQueue(@RequestBody CityQueue cityQueue){
        cityQueueService.updateCityQueue(cityQueue);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<CityQueue> getById(@RequestBody CityQueue cityQueue){
        return new ResponseEntity<>(cityQueueService.getById(cityQueue.getCity_id()), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteCityQueue(@RequestBody CityQueue cityQueue){
        cityQueueService.deleteById(cityQueue.getCity_id());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
