package com.social.travelguide.repository;

import com.social.travelguide.models.TravelPlaces;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface TravelRepository extends MongoRepository<TravelPlaces, String> {
    List<TravelPlaces> findByCategory(@Nullable String category);
    List<TravelPlaces> findByState(@Nullable String state);
    List<TravelPlaces> findByLocalPlacesName(@Nullable String name);
    @NonNull
    Page<TravelPlaces> findAll(@Nullable Pageable pageable);
}
