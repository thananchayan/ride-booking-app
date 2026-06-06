package com.nextgen.ridebooking.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {

  @NotBlank(message = "Customer name is required")
  private String customerName;

  @NotBlank(message = "Pickup location is required")
  private String pickupLocation;

  @NotBlank(message = "Destination is required")
  private String destination;
}