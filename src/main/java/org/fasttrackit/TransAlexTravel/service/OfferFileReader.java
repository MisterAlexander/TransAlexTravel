package org.fasttrackit.TransAlexTravel.service;

import lombok.SneakyThrows;
import org.fasttrackit.TransAlexTravel.model.Offer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class OfferFileReader implements DataProvider {
    @Value("${file.offers}")
    private String fileOffersPath;
    @SneakyThrows
    @Override
    public List<Offer> populateWithData() {
        return Files.lines(Path.of(fileOffersPath))
                .map(this::lineToOffers)
                .toList();
    }

    private Offer lineToOffers(String line) {
        String[] offersParts = line.split("\\|");
        return Offer.builder()
                .destination(offersParts[0])
                .duration(offersParts[1])
                .hotel(offersParts[2])
                .price(offersParts[3])
                .build();
    }
}
