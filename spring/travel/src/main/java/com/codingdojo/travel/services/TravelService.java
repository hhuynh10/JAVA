package com.codingdojo.travel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.travel.models.Travel;
import com.codingdojo.travel.repositories.TravelRepository;

@Service
public class TravelService {
private final TravelRepository travelRepository;
    
    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    public List<Travel> allTravels() {
        return travelRepository.findAll();
    }
   
    public Travel createTravel(Travel t) {
        return travelRepository.save(t);
    }
  
    public Travel findTravel(Long id) {
        Optional<Travel> optionalTravel = travelRepository.findById(id);
        if(optionalTravel.isPresent()) {
            return optionalTravel.get();
        } else {
            return null;
        }
    }
    
    public Travel updateTravel(Travel travel) {
		return travelRepository.save(travel);
	}
    
    public void deleteTravel(Long id) {
		Optional<Travel> optionalTravel = travelRepository.findById(id);
		if(optionalTravel.isPresent()) {
			travelRepository.deleteById(id);
		}
	}
}
