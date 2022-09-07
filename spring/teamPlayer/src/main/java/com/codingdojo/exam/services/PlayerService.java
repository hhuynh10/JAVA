package com.codingdojo.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.exam.models.Player;
import com.codingdojo.exam.repositories.PlayerRepository;

@Service
public class PlayerService {
	@Autowired
    private PlayerRepository playerRepo;
	
	public List<Player> allPlayers() {
        return playerRepo.findAll();
    }
	
	public Player createPlayer(Player p) {
        return playerRepo.save(p);
    }
}
