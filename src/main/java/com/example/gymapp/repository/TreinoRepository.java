package com.example.gymapp.repository;

import com.example.gymapp.model.Treino;
import com.example.gymapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {

    @Query("SELECT t FROM Treino t WHERE t.user = :user")
    List<Treino> findAllByUser(User user);
}
