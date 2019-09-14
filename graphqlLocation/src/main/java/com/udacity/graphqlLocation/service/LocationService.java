package com.udacity.graphqlLocation.service;

import com.udacity.graphqlLocation.entity.Location;

import java.util.List;

public interface LocationService {
    List<Location> retrieveLocations();
}
