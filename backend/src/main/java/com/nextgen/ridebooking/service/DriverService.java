package com.nextgen.ridebooking.service;

import com.nextgen.ridebooking.dto.DriverRequest;
import com.nextgen.ridebooking.entity.Driver;
import com.nextgen.ridebooking.enums.AvailabilityStatus;
import com.nextgen.ridebooking.exception.ResourceNotFoundException;
import com.nextgen.ridebooking.repository.DriverRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverService {

  private final DriverRepository driverRepository;

  public Driver createDriver(DriverRequest request) {
    if (driverRepository.existsByVehicleNumber(
        request.getVehicleNumber())) {

      throw new IllegalArgumentException(
          "Vehicle number already exists");
    }

    Driver driver = Driver.builder()
        .name(request.getName())
        .phone(request.getPhone())
        .vehicleNumber(request.getVehicleNumber())
        .availabilityStatus(AvailabilityStatus.AVAILABLE)
        .build();

    return driverRepository.save(driver);
  }

  public List<Driver> getAllDrivers() {
    return driverRepository.findAll();
  }

  public List<Driver> getAvailableDrivers() {
    return driverRepository.findByAvailabilityStatus(
        AvailabilityStatus.AVAILABLE
    );
  }

  public Driver updateAvailability(Long driverId, Boolean available) {

    Driver driver = driverRepository.findById(driverId)
        .orElseThrow(() ->
            new ResourceNotFoundException(
                "Driver not found with id: " + driverId
            ));

    driver.setAvailabilityStatus(
        available
            ? AvailabilityStatus.AVAILABLE
            : AvailabilityStatus.UNAVAILABLE
    );

    return driverRepository.save(driver);
  }
}