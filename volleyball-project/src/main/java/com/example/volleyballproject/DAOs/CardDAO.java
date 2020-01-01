package com.example.volleyballproject.DAOs;

import com.example.volleyballproject.DomainObjects.Card;
import com.example.volleyballproject.DomainObjects.Game;
import com.example.volleyballproject.DomainObjects.Person;
import com.example.volleyballproject.Enums.CardColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardDAO extends JpaRepository<Card, Long> {
    Card findById(Integer id);
    List<Card> findByColor(CardColor color);
    List<Card> findByPerson(Integer person);
    List<Card> findByGame(Integer game);
}
