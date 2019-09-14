package com.udacity.DogRestAPI.service;

import com.udacity.DogRestAPI.entity.Dog;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DogService {

    List<Dog> retrieveDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    String retrieveDogById(Long id);
    List<String> retrieveDogNames();

}
