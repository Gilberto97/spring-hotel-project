package com.prem.hotel.controllers;

import com.prem.hotel.models.Booking;
import com.prem.hotel.repo.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/my-bookings")
    public String myBookings(Model model) {
        Iterable<Booking> bookings = bookingRepository.findAll();
        model.addAttribute("title", "My Bookings");
        model.addAttribute("bookings", bookings);
        return "my-bookings";
    }

    @GetMapping("/book")
    public String book(Model model) {
        model.addAttribute("title", "Book");
        return "book";
    }

    @PostMapping("/book")
    public String bookPost(@RequestParam String room, @RequestParam Date startDate, @RequestParam Date endDate, Model model) {
        model.addAttribute("title", "Book");
        Booking booking = new Booking(room, startDate, endDate);
        return "book";
    }
}
