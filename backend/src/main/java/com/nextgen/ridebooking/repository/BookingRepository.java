package com.nextgen.ridebooking.repository;

import com.nextgen.ridebooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository
    extends JpaRepository<Booking, Long> {

}
