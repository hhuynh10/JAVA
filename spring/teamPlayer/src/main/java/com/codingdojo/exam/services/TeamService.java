package com.codingdojo.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.exam.models.Team;
import com.codingdojo.exam.repositories.TeamRepository;

@Service
public class TeamService {
	@Autowired
    private TeamRepository teamRepo;
	
	public List<Team> allTeams() {
        return teamRepo.findAll();
    }
	
	public Team createTeam(Team t) {
        return teamRepo.save(t);
    }
	
	public Team findTeam(Long id) {
        Optional<Team> optionalTeam = teamRepo.findById(id);
        if(optionalTeam.isPresent()) {
            return optionalTeam.get();
        } else {
            return null;
        }
    }
	
	public Team updateTeam(Team team) {
		return teamRepo.save(team);
	}
    
    public void deleteTeam(Long id) {
    	teamRepo.deleteById(id);
    }
}
