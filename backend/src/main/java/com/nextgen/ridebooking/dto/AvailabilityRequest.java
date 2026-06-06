package com.nextgen.ridebooking.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvailabilityRequest {

  @NotNull(message = "Availability status is required")
  private Boolean available;
}