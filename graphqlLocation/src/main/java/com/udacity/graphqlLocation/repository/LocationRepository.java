package com.udacity.graphqlLocation.repository;

import com.udacity.graphqlLocation.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
