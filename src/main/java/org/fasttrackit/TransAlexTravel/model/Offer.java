package org.fasttrackit.TransAlexTravel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@With
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Offer{

        @Id
        @GeneratedValue

        private Long id;
        @Column
        private String destination;
        @Column
        private String duration;
        @Column
        private String hotel;
        @Column
        private String price;

}
