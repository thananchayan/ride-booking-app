package com.nextgen.ridebooking.controller;

import com.nextgen.ridebooking.dto.AvailabilityRequest;
import com.nextgen.ridebooking.dto.DriverRequest;
import com.nextgen.ridebooking.entity.Driver;
import com.nextgen.ridebooking.service.DriverService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/drivers")
@RequiredArgsConstructor
public class DriverController {

  private final DriverService driverService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Driver createDriver(
      @Valid @RequestBody DriverRequest request) {

    return driverService.createDriver(request);
  }

  @GetMapping
  public List<Driver> getAllDrivers() {
    return driverService.getAllDrivers();
  }

  @GetMapping("/available")
  public List<Driver> getAvailableDrivers() {
    return driverService.getAvailableDrivers();
  }

  @PutMapping("/{id}/availability")
  public Driver updateAvailability(
      @PathVariable Long id,
      @Valid @RequestBody AvailabilityRequest request) {

    return driverService.updateAvailability(
        id,
        request.getAvailable()
    );
  }
}