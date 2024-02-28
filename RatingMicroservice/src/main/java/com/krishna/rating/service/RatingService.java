package com.krishna.rating.service;

import com.krishna.rating.model.Rating;
import com.krishna.rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating addRating(Rating rating)
    {
        return ratingRepository.save(rating);
    }

    public List<Rating> getAllRating()
    {
        return ratingRepository.findAll();
    }

    public List<Rating> getRatingByUserId(Integer id)
    {
        return ratingRepository.findByUserId(id);
    }

    public List<Rating> getRatingByHotelId(Integer id)
    {
        return ratingRepository.findByHotelId(id);
    }
}
