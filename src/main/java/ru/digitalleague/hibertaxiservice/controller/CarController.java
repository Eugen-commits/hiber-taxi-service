package ru.digitalleague.hibertaxiservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.hibertaxiservice.persistance.entity.Car;
import ru.digitalleague.hibertaxiservice.service.CarService;

import java.util.List;


@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;


    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createCar (@RequestBody Car car){
        carService.createCar(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars(){
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<Car>getCarById(@RequestBody Car car){
        return new ResponseEntity<>(carService.getCarById(car.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteById(@RequestBody Car car){
        carService.deleteCarById(car.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<HttpStatus> updateCar(@RequestBody Car car){
        carService.updateCar(car);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/model")
    public ResponseEntity<Car> getCarByModel (@RequestBody Car car){
        return new ResponseEntity<>(carService.getByModel(car.getModel()), HttpStatus.OK);
    }
}
