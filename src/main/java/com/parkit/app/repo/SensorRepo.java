package com.parkit.app.repo;

import com.parkit.app.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepo extends JpaRepository<Sensor, Integer> {
    List<Sensor> findSensorsByParking_Id(int id);
}
