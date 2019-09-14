package com.udacity.graphqlLocation.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.graphqlLocation.entity.Location;
import com.udacity.graphqlLocation.repository.LocationRepository;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private LocationRepository locationRepository;

    public Query(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Iterable<Location> findAllLocations() {
        return locationRepository.findAll();
    }
}
