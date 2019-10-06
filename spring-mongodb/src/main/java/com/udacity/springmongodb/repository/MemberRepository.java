package com.udacity.springmongodb.repository;

import com.udacity.springmongodb.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {

    Optional<Member> findByFirstName(String firstName);

    Optional<Member> findByLastName(String lastName);
}
