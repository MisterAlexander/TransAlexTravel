package org.fasttrackit.TransAlexTravel.service;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.TransAlexTravel.model.Offer;
import org.fasttrackit.TransAlexTravel.repository.OfferRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor

public class CommandRunner implements CommandLineRunner {
    private final OfferRepository repository;
    private final OfferFileReader offerFileReader;
    @Override
    public void run(String... args) {
        this.repository.saveAll(offerFileReader.populateWithData());
        this.repository.save(Offer.builder()
                .build());

    }

}
