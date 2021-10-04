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

    //Создать машину
    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createCar (@RequestBody Car car){
        carService.createCar(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //Список всех машин
    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars(){
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }
    //Получить машину по ID
    @GetMapping("/get")
    public ResponseEntity<Car>getCarById(@RequestBody Car car){
        return new ResponseEntity<>(carService.getCarById(car.getId()), HttpStatus.OK);
    }
    //Удалить машину по ID
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteById(@RequestBody Car car){
        carService.deleteCarById(car.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //Обновить данные машины
    @PostMapping("/update")
    public ResponseEntity<HttpStatus> updateCar(@RequestBody Car car){
        carService.updateCar(car);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //Получить машину по модели
    @GetMapping("/model")
    public ResponseEntity<Car> getCarByModel (@RequestBody Car car){
        return new ResponseEntity<>(carService.getByModel(car.getModel()), HttpStatus.OK);
    }
}
