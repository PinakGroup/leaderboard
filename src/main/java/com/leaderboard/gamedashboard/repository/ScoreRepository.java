package com.leaderboard.gamedashboard.repository;

import com.leaderboard.gamedashboard.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {


    @Query(value = "SELECT s FROM Score s WHERE s.user.id =:user_id ORDER BY s.score DESC")
    List<Score> getUserHighScore(@Param("user_id") long user_id);

    /*@Query(value = "SELECT u from User u,Score s where s.")
    List<Score> getAllUserHighScore();*/

}
