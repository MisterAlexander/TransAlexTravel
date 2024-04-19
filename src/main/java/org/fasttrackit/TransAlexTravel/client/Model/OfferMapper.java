package org.fasttrackit.TransAlexTravel.client.Model;

import org.fasttrackit.TransAlexTravel.model.Offer;
import org.springframework.stereotype.Component;

@Component

public class OfferMapper {
    public static OfferDTO toDto(Offer offer) {
        return OfferDTO.builder()
                .id(offer.getId())
                .destination(offer.getDestination())
                .duration(offer.getDuration())
                .hotel(offer.getHotel())
                .price(offer.getPrice())
                .build();
    }

    public static Offer toEntity(OfferAddDTO offerDTO) {
        return Offer.builder()
                .id(offerDTO.id())
                .destination(offerDTO.destination())
                .duration(offerDTO.destination())
                .hotel(offerDTO.hotel())
                .price(offerDTO.price())
                .build();

    }
}
