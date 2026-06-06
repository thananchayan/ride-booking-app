package com.nextgen.ridebooking.controller;

import com.nextgen.ridebooking.dto.BookingRequest;
import com.nextgen.ridebooking.dto.BookingResponse;
import com.nextgen.ridebooking.entity.Booking;
import com.nextgen.ridebooking.service.BookingService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

  private final BookingService bookingService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BookingResponse createBooking(
      @Valid @RequestBody BookingRequest request) {

    return bookingService.createBooking(request);
  }

  @GetMapping
  public List<Booking> getAllBookings() {
    return bookingService.getAllBookings();
  }
}
