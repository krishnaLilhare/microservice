package com.krishna.hotel.controller;

import com.krishna.hotel.model.Hotel;
import com.krishna.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/add")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        Hotel hotel1 = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Hotel>> getAllHotel()
    {
        List<Hotel> hotels = hotelService.getAllHotel();
        return ResponseEntity.status(HttpStatus.OK).body(hotels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Integer id)
    {
        Hotel hotel = hotelService.getHotelById(id);
        return  ResponseEntity.status(HttpStatus.OK).body(hotel);
    }
}
