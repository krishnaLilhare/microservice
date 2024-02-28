package com.krishna.user.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private Integer ratingId;
    private Integer userId;
    private Integer hotelId;
    private int rating;
    private String feedback;
    private Hotel hotel;
}
