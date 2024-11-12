package com.social.travelguide.repository;

import com.social.travelguide.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User , String > {
    Optional<User> findByUsername(String username);
    User findByEmail(String email);
    List<User> findByCity(String city);
}
