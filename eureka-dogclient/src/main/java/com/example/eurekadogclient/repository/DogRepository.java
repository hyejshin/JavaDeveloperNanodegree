package com.example.eurekadogclient.repository;

import com.example.eurekadogclient.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
