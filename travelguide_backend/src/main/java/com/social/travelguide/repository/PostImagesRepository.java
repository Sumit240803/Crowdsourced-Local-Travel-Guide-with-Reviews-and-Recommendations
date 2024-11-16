package com.social.travelguide.repository;

import com.social.travelguide.models.PostImages;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostImagesRepository extends MongoRepository<PostImages,String> {
    List<PostImages> findByUserId(String userId);
}
