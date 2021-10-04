package ru.digitalleague.hibertaxiservice.persistance.repository;

import org.springframework.data.repository.CrudRepository;
import ru.digitalleague.hibertaxiservice.persistance.entity.TaxiDriveInfo;

import java.util.List;


public interface TaxiDriverInfoRepository extends CrudRepository<TaxiDriveInfo, Long> {
    List<TaxiDriveInfo> getAllByCarModel(String carModel);
}
