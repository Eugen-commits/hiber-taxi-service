package ru.digitalleague.hibertaxiservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.digitalleague.hibertaxiservice.persistance.entity.TaxiDriveInfo;
import ru.digitalleague.hibertaxiservice.persistance.repository.TaxiDriverInfoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional
public class TaxiDriverInfoService {
    @Autowired
    private TaxiDriverInfoRepository repository;

    public List<TaxiDriveInfo> getAllTaxiDriverInfo(){
        List<TaxiDriveInfo> taxiDriveInfos = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(taxiDriveInfos::add);
        return taxiDriveInfos;
    }

    public void createDriver(TaxiDriveInfo driverInfo){
        log.info("New Driver is - " + driverInfo.toString());
        repository.save(driverInfo);
    }

    public TaxiDriveInfo getDriverById(Long id){
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void deleteDriver(Long id){
        repository.deleteById(id);
    }

    public void update(TaxiDriveInfo taxiDriveInfo){
        repository.save(taxiDriveInfo);
    }

    public List<TaxiDriveInfo> getAllByCarModel(String carModel){
        List<TaxiDriveInfo> listOfDriverByCarModel = new ArrayList<>();
        repository.getAllByCarModel(carModel).iterator().forEachRemaining(listOfDriverByCarModel::add);
        return listOfDriverByCarModel;
    }
}
