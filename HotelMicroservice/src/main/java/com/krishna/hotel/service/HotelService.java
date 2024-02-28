package com.krishna.hotel.service;

import com.krishna.hotel.model.Hotel;
import com.krishna.hotel.respository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
       Optional<Hotel> optionalHotel = hotelRepository.findById(id);

       if(optionalHotel.isPresent())
       {
           return optionalHotel.get();
       }else {
           throw new RuntimeException("Hotel is not present with id = "+id);
       }
    }
}
