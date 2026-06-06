package com.nextgen.ridebooking.service;

import com.nextgen.ridebooking.dto.BookingRequest;
import com.nextgen.ridebooking.dto.BookingResponse;
import com.nextgen.ridebooking.entity.Booking;
import com.nextgen.ridebooking.entity.Driver;
import com.nextgen.ridebooking.enums.AvailabilityStatus;
import com.nextgen.ridebooking.enums.BookingStatus;
import com.nextgen.ridebooking.repository.BookingRepository;
import com.nextgen.ridebooking.repository.DriverRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

  private final BookingRepository bookingRepository;
  private final DriverRepository driverRepository;

  public BookingResponse createBooking(
      BookingRequest request) {

    Driver driver = driverRepository
        .findFirstByAvailabilityStatus(
            AvailabilityStatus.AVAILABLE)
        .orElseThrow(() ->
            new IllegalArgumentException(
                "No available drivers found"));

    driver.setAvailabilityStatus(
        AvailabilityStatus.UNAVAILABLE);

    driverRepository.save(driver);

    Booking booking = Booking.builder()
        .customerName(request.getCustomerName())
        .pickupLocation(request.getPickupLocation())
        .destination(request.getDestination())
        .bookingTime(LocalDateTime.now())
        .status(BookingStatus.CONFIRMED)
        .driver(driver)
        .build();

    Booking savedBooking =
        bookingRepository.save(booking);

    return BookingResponse.builder()
        .bookingId(savedBooking.getId())
        .driverName(driver.getName())
        .vehicleNumber(driver.getVehicleNumber())
        .status(savedBooking.getStatus().name())
        .build();
  }

  public List<Booking> getAllBookings() {
    return bookingRepository.findAll();
  }
}
