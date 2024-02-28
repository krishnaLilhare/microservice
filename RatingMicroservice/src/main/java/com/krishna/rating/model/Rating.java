package com.krishna.rating.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ratings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ratingId;
    private Integer userId;
    private Integer hotelId;
    private int rating;
    private String feedback;
}
