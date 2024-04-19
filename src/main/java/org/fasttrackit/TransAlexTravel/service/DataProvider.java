package org.fasttrackit.TransAlexTravel.service;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DataProvider {
    List<?> populateWithData();
}
