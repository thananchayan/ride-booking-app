package com.nextgen.ridebooking.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookingResponse {

  private Long bookingId;

  private String driverName;

  private String vehicleNumber;

  private String status;
}
