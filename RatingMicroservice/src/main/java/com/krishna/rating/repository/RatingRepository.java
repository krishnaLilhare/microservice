package com.krishna.rating.repository;

import com.krishna.rating.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,Integer> {

    public List<Rating> findByUserId(Integer userId);
    public List<Rating> findByHotelId(Integer hotelId);
}
