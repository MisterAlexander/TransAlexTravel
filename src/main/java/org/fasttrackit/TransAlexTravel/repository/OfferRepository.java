package org.fasttrackit.TransAlexTravel.repository;

import org.fasttrackit.TransAlexTravel.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {
    List<Offer> findAllByDuration(String duration);
    List<Offer> findAllByPrice(String price);
    List<Offer> findAllByHotel(String hotel);
    List<Offer> findAllByDestination(String destination);
}
