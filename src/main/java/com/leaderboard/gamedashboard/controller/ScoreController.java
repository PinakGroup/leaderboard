package com.leaderboard.gamedashboard.controller;

import com.leaderboard.gamedashboard.dto.ScoreDTO;
import com.leaderboard.gamedashboard.exception.CustomException;
import com.leaderboard.gamedashboard.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/add")
    public ResponseEntity<?> addScore(@RequestBody ScoreDTO scoreDTO) {
        try {
            return scoreService.addScore(scoreDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to add score. Operation unsuccessful");
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        try {
            return scoreService.getAllScores();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to fetch scores. Operation unsuccessful");
        }
    }


}
