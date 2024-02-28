package com.krishna.user.external.service;

import com.krishna.user.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingServiceController {

    @GetMapping("/rating/user/{id}")
    public List<Rating> getAllRatingByUserId(@PathVariable Integer id);
}
