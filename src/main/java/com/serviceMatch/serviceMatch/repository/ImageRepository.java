package com.serviceMatch.serviceMatch.repository;

import com.serviceMatch.serviceMatch.entities.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
