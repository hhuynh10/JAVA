package com.codingdojo.bike.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bike.models.Bike;

@Repository
public interface BikeRepository extends CrudRepository<Bike, Long> {
	List<Bike> findAll();
    List<Bike> findByUserIdIs(Long userId);
	List<Bike> findByBuyerIdIs(Long userId);
	List<Bike> findByBuyerIdIsOrUserIdIs(Long bikeID, Long userId);
}
