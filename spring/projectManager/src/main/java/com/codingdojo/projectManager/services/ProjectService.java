package com.codingdojo.projectManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.projectManager.models.Project;
import com.codingdojo.projectManager.models.User;
import com.codingdojo.projectManager.repositories.ProjectRepository;



@Service
public class ProjectService {
	@Autowired
    private ProjectRepository projectRepo;
	
	public List<Project> allProjects() {
        return projectRepo.findAll();
    }
	
	public List<Project> unjoinedTeams(User user){
		return projectRepo.findByTeamIdIsOrUserIdIs(null, user.getId());
	}
	
	public List<Project> joinedTeams(User user){
		return projectRepo.findByTeamIdIs(user.getId());
	}
	
	public List<Project> myTeams(User user){
		return projectRepo.findByUserIdIs(user.getId());
	}
	
	public Project createProject(Project p) {
        return projectRepo.save(p);
    }
	
	public Project findProject(Long id) {
        Optional<Project> optionalProject = projectRepo.findById(id);
        if(optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }
	
	public Project updateProject(Project project) {
		return projectRepo.save(project);
	}
    
    public void deleteProject(Long id) {
    	projectRepo.deleteById(id);
    }
    
    public void leaveTeam(Project project) {
    	project.setTeam(null);
    	projectRepo.save(project);
	}
	
	public void joinTeam(Project project, User user) {
		project.setTeam(user);
    	projectRepo.save(project);
	}
}
