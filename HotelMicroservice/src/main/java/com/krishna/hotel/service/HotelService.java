package com.krishna.hotel.service;

import com.krishna.hotel.model.Hotel;
import com.krishna.hotel.respository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel createHotel(Hotel hotel)
    {
        return  hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotel()
    {
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(Integer id)
    {
        return hotelRepository.findById(id).orElseThrow();
    }
}
