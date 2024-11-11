package com.social.travelguide.repository;

import com.social.travelguide.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User , String > {
    User findByEmail(String email);
    List<User> findByCity(String city);
}
