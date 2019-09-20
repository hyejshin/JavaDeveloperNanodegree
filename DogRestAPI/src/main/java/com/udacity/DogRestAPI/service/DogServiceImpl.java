package com.udacity.DogRestAPI.service;

import com.udacity.DogRestAPI.entity.Dog;
import com.udacity.DogRestAPI.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    DogRepository dogRepository;

    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    public List<String> retrieveDogBreed() {
        return dogRepository.findAllBreed();
    }

    public String retrieveDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }

    public Dog retrieveDogById(Long id) {
        //Optional<Dog> optionalDog = Optional.ofNullable(dogRepository.findDogById(id));
        //String dog = optionalDog.orElseThrow(DogNotFoundException::new);
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent())
            return optionalDog.get();
        else
            throw new RuntimeException();
    }

    public List<String> retrieveDogNames() {
        return dogRepository.findAllName();
    }
}
