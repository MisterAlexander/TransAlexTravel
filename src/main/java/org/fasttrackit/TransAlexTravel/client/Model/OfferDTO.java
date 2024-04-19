package org.fasttrackit.TransAlexTravel.client.Model;

import lombok.Builder;

@Builder

public record OfferDTO(
        Long id,
        String destination,
        String duration,
        String hotel,
        String price

) {
}
