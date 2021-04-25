package com.prem.hotel.repo;

import com.prem.hotel.models.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

}
