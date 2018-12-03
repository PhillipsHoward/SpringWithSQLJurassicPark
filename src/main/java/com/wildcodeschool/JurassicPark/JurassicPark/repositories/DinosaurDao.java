package com.wildcodeschool.JurassicPark.JurassicPark.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.JurassicPark.JurassicPark.entities.Dinosaur;

@Repository
public interface DinosaurDao extends JpaRepository<Dinosaur, Long> {
	
	
}