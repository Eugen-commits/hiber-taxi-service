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
    //Список всех очередей по городам
    @GetMapping("/all")
    public ResponseEntity<List<CityQueue>> getAll(){
       return new ResponseEntity<>(cityQueueService.getAllQueue(), HttpStatus.OK);
    }
    //Создать очередь по городу
    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createCityQueue(@RequestBody CityQueue cityQueue){
        cityQueueService.createCityQueue(cityQueue);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //Обновить запись
    @PostMapping("/update")
    public ResponseEntity<CityQueue> updateCityQueue(@RequestBody CityQueue cityQueue){
        cityQueueService.updateCityQueue(cityQueue);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //Получить по ID
    @GetMapping("/get")
    public ResponseEntity<CityQueue> getById(@RequestBody CityQueue cityQueue){
        return new ResponseEntity<>(cityQueueService.getById(cityQueue.getCity_id()), HttpStatus.OK);
    }
    //Удалить по ID
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteCityQueue(@RequestBody CityQueue cityQueue){
        cityQueueService.deleteById(cityQueue.getCity_id());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
