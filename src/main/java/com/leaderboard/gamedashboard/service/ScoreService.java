package com.leaderboard.gamedashboard.service;

import com.leaderboard.gamedashboard.dto.ScoreDTO;
import org.springframework.http.ResponseEntity;

public interface ScoreService {

    ResponseEntity<?> addScore(ScoreDTO scoreDTO) throws Exception;

    ResponseEntity<?> getAllScores() throws Exception;




}
