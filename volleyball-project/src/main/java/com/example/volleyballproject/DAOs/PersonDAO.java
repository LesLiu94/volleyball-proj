package com.example.volleyballproject.DAOs;

import com.example.volleyballproject.DomainObjects.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDAO extends JpaRepository<Person, Long> {
    Person findById(Integer id);
    List<Person> findByFirstNameAndLastName(String firstName, String lastName);

}
