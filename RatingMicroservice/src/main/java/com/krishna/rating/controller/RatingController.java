package com.krishna.rating.controller;

import com.krishna.rating.model.Rating;
import com.krishna.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/add")
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating)
    {
        Rating rating1 = ratingService.addRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating1);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Rating>> getAllRating()
    {
       List<Rating> ratings = ratingService.getAllRating();
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable Integer id)
    {
        List<Rating> ratings = ratingService.getRatingByUserId(id);
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }

    @GetMapping("hotel/{id}")
    public ResponseEntity<List<Rating>> getRatingByHotel(@PathVariable Integer id)
    {
        List<Rating> ratings = ratingService.getRatingByHotelId(id);
        return ResponseEntity.status(HttpStatus.OK).body(ratings);
    }
}
