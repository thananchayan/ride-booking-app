package com.nextgen.ridebooking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverRequest {

  @NotBlank(message = "Driver name is required")
  private String name;

  @NotBlank(message = "Phone number is required")
  @Pattern(
      regexp = "^[0-9]{10}$",
      message = "Phone number must contain exactly 10 digits"
  )
  private String phone;

  @NotBlank(message = "Vehicle number is required")
  private String vehicleNumber;
}