package ru.digitalleague.hibertaxiservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.digitalleague.hibertaxiservice.persistance.entity.Car;
import ru.digitalleague.hibertaxiservice.persistance.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public void createCar(Car car){
        log.info("New car is - " + car.toString());
        carRepository.save(car);
    }

    public List<Car> getAllCars(){
        List<Car> allCars = new ArrayList<>();
        carRepository.findAll().iterator().forEachRemaining(allCars::add);
        return allCars;
    }

    public Car getCarById(Long id){
        return carRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void deleteCarById(Long id){
        carRepository.deleteById(id);
    }

    public void updateCar(Car car){
        String oldCar = getCarById(car.getId()).toString();
        carRepository.save(car);
        log.info("old car is " + oldCar + " " + "new car is - " + car);
    }

    public Car getByModel(String model){
       return carRepository.findByModel(model);
    }
}
