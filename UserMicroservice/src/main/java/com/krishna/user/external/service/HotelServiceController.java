package com.krishna.user.external.service;

import com.krishna.user.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelServiceController {
    @GetMapping("/hotel/{id}")
    public Hotel getHotelById(@PathVariable Integer id);
}
