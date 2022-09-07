package com.codingdojo.bike.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bike.models.Bike;
import com.codingdojo.bike.models.User;
import com.codingdojo.bike.repositories.BikeRepository;

@Service
public class BikeService {
	@Autowired
    private BikeRepository bikeRepo;
	
	public List<Bike> allBikes() {
        return bikeRepo.findAll();
    }
	
	public List<Bike> unjoinedBuyers(User user){
		return bikeRepo.findByBuyerIdIsOrUserIdIs(null, user.getId());
	}
	
	public List<Bike> joinedBuyers(User user){
		return bikeRepo.findByBuyerIdIs(user.getId());
	}
	
	public List<Bike> myBikes(User user){
		return bikeRepo.findByUserIdIs(user.getId());
	}
	
	public Bike findBike(Long id) {
        Optional<Bike> optionalBike = bikeRepo.findById(id);
        if(optionalBike.isPresent()) {
            return optionalBike.get();
        } else {
            return null;
        }
    }
	
	public Bike addBike(Bike b) {
        return bikeRepo.save(b);
    }
	
	public Bike updateBike(Bike bike) {
		return bikeRepo.save(bike);
	}
    
    public void deleteBike(Long id) {
    	bikeRepo.deleteById(id);
    }
    
    public void sellBike(Bike bike) {
    	bike.setBuyer(null);
    	bikeRepo.save(bike);
	}
	
	public void buyBike(Bike bike, User user) {
		bike.setBuyer(user);
		bikeRepo.save(bike);
	}
}
