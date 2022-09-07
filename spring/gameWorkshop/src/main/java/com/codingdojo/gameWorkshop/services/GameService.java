package com.codingdojo.gameWorkshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.gameWorkshop.models.Game;
import com.codingdojo.gameWorkshop.repositories.GameRepository;

@Service
public class GameService {
	@Autowired
    private GameRepository gameRepo;
	
	public List<Game> allGames() {
        return gameRepo.findAll();
    }
	
	public Game createGame(Game g) {
        return gameRepo.save(g);
    }
	
	public Game findGame(Long id) {
        Optional<Game> optionalGame = gameRepo.findById(id);
        if(optionalGame.isPresent()) {
            return optionalGame.get();
        } else {
            return null;
        }
    }
	
	public Game updateGame(Game game) {
		return gameRepo.save(game);
	}
    
    public void deleteGame(Long id) {
    	gameRepo.deleteById(id);
    }
}
