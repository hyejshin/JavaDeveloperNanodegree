package com.udacity.graphqlLocation.service;

import com.udacity.graphqlLocation.entity.Location;
import com.udacity.graphqlLocation.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;

    public List<Location> retrieveLocations() {
        return (List<Location>) locationRepository.findAll();
    }
}
