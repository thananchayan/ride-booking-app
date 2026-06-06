package com.nextgen.ridebooking.repository;

import com.nextgen.ridebooking.entity.Driver;
import com.nextgen.ridebooking.enums.AvailabilityStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DriverRepository
    extends JpaRepository<Driver, Long> {

  List<Driver> findByAvailabilityStatus(
      AvailabilityStatus status);
  boolean existsByVehicleNumber(String vehicleNumber);
}