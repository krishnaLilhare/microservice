package com.krishna.hotel.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hotels")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String hotelName;
    private String address;
}
