package com.example.volleyballproject.DAOs;

import com.example.volleyballproject.DomainObjects.Management;
import com.example.volleyballproject.Enums.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagementDAO extends JpaRepository<Management, Long> {
    Management findById(Integer id);
    List<Management> findByTeamId(Integer teamId);
    List<Management> findByTitle(Title title);
}
