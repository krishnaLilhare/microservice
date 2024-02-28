package com.krishna.user.service;

import com.krishna.user.external.service.HotelServiceController;
import com.krishna.user.external.service.RatingServiceController;
import com.krishna.user.model.Hotel;
import com.krishna.user.model.Rating;
import com.krishna.user.model.User;
import com.krishna.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelServiceController hotelServiceController;

    @Autowired
    private RatingServiceController ratingServiceController;

    public User createUser(User user)
    {
        return userRepository.save(user);
    }

    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }

    public User getByUser(Integer id)
    {

        // *****  using rest template   *****

//        User user = userRepository.findById(id).orElseThrow();
//        Rating[] ratingArray = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+id, Rating[].class);
//
//        if(ratingArray != null) {
//            List<Rating> ratings = Arrays.asList(ratingArray);
//
//            for (Rating rating : ratings) {
//
//                Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(), Hotel.class);
//                rating.setHotel(hotel);
//            }
//            user.setRatings(ratings);
//            return user;
//        }
//      return null;

        // *****  using feign client   *****

        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isPresent())
        {
            User user = optionalUser.get();
            List<Rating> ratings = ratingServiceController.getAllRatingByUserId(user.getId());

            for (Rating rating : ratings) {
                Hotel hotel = hotelServiceController.getHotelById(rating.getHotelId());
                rating.setHotel(hotel);
            }
            user.setRatings(ratings);
            return user;
        }else {
            throw new RuntimeException("user not found with id = "+id);
        }
    }
}
