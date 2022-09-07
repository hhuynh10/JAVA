package com.codingdojo.travel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.travel.models.Travel;

@Repository
public interface TravelRepository extends CrudRepository<Travel, Long>{
	List<Travel> findAll();
}
