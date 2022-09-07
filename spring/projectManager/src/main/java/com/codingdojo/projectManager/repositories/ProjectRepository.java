package com.codingdojo.projectManager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.projectManager.models.Project;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    
    List<Project> findAll();
    List<Project> findByUserIdIs(Long userId);
	List<Project> findByTeamIdIs(Long userId);
	List<Project> findByTeamIdIsOrUserIdIs(Long teamID, Long userId);
}