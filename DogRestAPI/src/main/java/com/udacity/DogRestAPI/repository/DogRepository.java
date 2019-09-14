package com.udacity.DogRestAPI.repository;

import com.udacity.DogRestAPI.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {
    @Query("select d.id, d.breed from Dog d where d.id=:id")
    String findBreedById(@Param("id") Long id);

    @Query("select d.id, d.breed, d.name from Dog d where d.id=:id")
    String findDogById(@Param("id") Long id);

    @Query("select d.id, d.breed from Dog d")
    List<String> findAllBreed();

    @Query("select d.id, d.name from Dog d")
    List<String> findAllName();
}
