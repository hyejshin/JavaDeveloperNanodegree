package com.udacity.DogRestAPI.service;

import com.udacity.DogRestAPI.entity.Dog;

import java.util.List;

public interface DogService {

    List<Dog> retrieveDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    Dog retrieveDogById(Long id);
    List<String> retrieveDogNames();

}
