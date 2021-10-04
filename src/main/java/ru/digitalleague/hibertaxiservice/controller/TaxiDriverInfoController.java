package ru.digitalleague.hibertaxiservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.hibertaxiservice.persistance.entity.TaxiDriveInfo;
import ru.digitalleague.hibertaxiservice.service.TaxiDriverInfoService;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class TaxiDriverInfoController {
    @Autowired
    private TaxiDriverInfoService taxiDriverInfoService;
    //Список всех водителей
    @GetMapping("/all")
    public ResponseEntity<List<TaxiDriveInfo>> getAllDrivers (){
        return new ResponseEntity<>(taxiDriverInfoService.getAllTaxiDriverInfo(), HttpStatus.OK);
    }
    //Создать водителя
    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createDriver(@RequestBody TaxiDriveInfo taxiDriveInfo){
        taxiDriverInfoService.createDriver(taxiDriveInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //Получить водителя по ID
    @GetMapping("/get")
    public ResponseEntity<TaxiDriveInfo> getDriverById(@RequestBody TaxiDriveInfo taxiDriveInfo){
        return new ResponseEntity<>(taxiDriverInfoService.getDriverById(taxiDriveInfo.getDriver_id()),HttpStatus.OK);
    }
    //Удалить водителя по ID
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteDriverById(@RequestBody TaxiDriveInfo taxiDriveInfo){
        taxiDriverInfoService.deleteDriver(taxiDriveInfo.getDriver_id());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //Обновить водителя
    @PostMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody TaxiDriveInfo taxiDriveInfo){
        taxiDriverInfoService.update(taxiDriveInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //Список водителей по марке машины
    @GetMapping("/models")
    public ResponseEntity<List<TaxiDriveInfo>> getAllByCarModel(@RequestBody TaxiDriveInfo taxiDriveInfo){
        return new ResponseEntity<>(taxiDriverInfoService.getAllByCarModel(taxiDriveInfo.getCarModel()), HttpStatus.OK);
    }
}
