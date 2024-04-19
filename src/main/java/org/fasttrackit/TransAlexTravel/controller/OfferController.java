package org.fasttrackit.TransAlexTravel.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.TransAlexTravel.client.Model.OfferAddDTO;
import org.fasttrackit.TransAlexTravel.client.Model.OfferDTO;
import org.fasttrackit.TransAlexTravel.client.Model.OfferMapper;
import org.fasttrackit.TransAlexTravel.model.Offer;
import org.fasttrackit.TransAlexTravel.service.OfferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.fasttrackit.TransAlexTravel.client.Model.OfferMapper.toDto;
import static org.fasttrackit.TransAlexTravel.client.Model.OfferMapper.toEntity;

@RestController
@RequestMapping("offers")
@RequiredArgsConstructor
@CrossOrigin(value = "http://localhost:4200")

public class OfferController {
    private final OfferService service;

    @GetMapping
public List<OfferDTO> getAllOffers(String destination, String duration) {
        if (destination != null) {
            return service.getAllOffersByDestination(destination).stream()
                    .map(OfferMapper::toDto)
                    .toList();
        }
        if (duration != null){
            return service.getAllOffersByDuration(duration).stream()
                    .map(OfferMapper::toDto)
                    .toList();
        }
        return service.getAllOffers().stream()
                .map(OfferMapper::toDto)
                .toList();

    }

    @GetMapping("{id}")
    public OfferDTO getOneOffer(@PathVariable Long id) {

        return toDto(service.getOfferById(id));
    }

    @DeleteMapping("{id}")
    public OfferDTO deleteById(@PathVariable Long id) {
        return toDto(service.deleteById(id));
    }
@PostMapping
    public OfferDTO addOffer(@RequestBody OfferAddDTO newOffer){
Offer offerEntity = service.addNewOffer(toEntity(newOffer));
return toDto(offerEntity);
    }

@PutMapping("{id}")
    public OfferDTO replaceOffer(@PathVariable Long id, @RequestBody OfferAddDTO replaceOffer){
return toDto(service.replaceOffer(id, toEntity(replaceOffer)));
}

}