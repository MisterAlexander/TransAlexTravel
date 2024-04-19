package org.fasttrackit.TransAlexTravel.service;

import org.fasttrackit.TransAlexTravel.repository.OfferRepository;
import org.fasttrackit.TransAlexTravel.exceptions.ResourceNotFound;
import org.fasttrackit.TransAlexTravel.model.Offer;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OfferService {
    private final OfferRepository repository;

    public OfferService(OfferRepository repository) {
        this.repository = repository;

    }

    public List<Offer> getAllOffers() {
        return repository.findAll();
    }

    public Offer getOfferById(Long id) {
Offer offer = repository.findById(id)
        .orElseThrow(()-> new ResourceNotFound("Offer with id%s was not found".formatted(id)));
return offer;
    }

    public List<Offer> getAllOffersByDuration(String duration) {
        return repository.findAllByDuration(duration);
    }

    public List<Offer> getAllOffersByPrice(String price) {
        return repository.findAllByPrice(price);
    }

    public List<Offer> getAllOffersByHotel(String hotel) {

        return repository.findAllByHotel(hotel);
    }

    public List<Offer> getAllOffersByDestination(String destination) {
        return repository.findAllByDestination(destination);
    }


    public Offer deleteById(Long id) {
        Offer foundOffer = getOfferById(id);
        repository.deleteById(id);
        return foundOffer;
    }

    public Offer addNewOffer(Offer newOffer) {
        return repository.save(newOffer);
    }

    public Offer replaceOffer(Long id, Offer replaceOffer) {
        Offer foundOffer = getOfferById(id);
        Offer updatedOffer = Offer.builder()
                .id(foundOffer.getId())
                .destination(replaceOffer.getDestination())
                .duration(replaceOffer.getDuration())
                .hotel(replaceOffer.getHotel())
                .price(replaceOffer.getPrice())
                .build();
        return repository.save(updatedOffer);

    }
}

