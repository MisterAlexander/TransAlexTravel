package org.fasttrackit.TransAlexTravel.client.Model;

import lombok.Builder;

@Builder

public record OfferAddDTO(
Long id,
String destination,
String duration,
String hotel,
String price

) {
}
