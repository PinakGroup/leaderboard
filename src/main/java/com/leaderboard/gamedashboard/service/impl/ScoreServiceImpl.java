package com.leaderboard.gamedashboard.service.impl;

import com.leaderboard.gamedashboard.dto.ScoreDTO;
import com.leaderboard.gamedashboard.dto.UserDTO;
import com.leaderboard.gamedashboard.model.ResponseModel;
import com.leaderboard.gamedashboard.model.Score;
import com.leaderboard.gamedashboard.model.User;
import com.leaderboard.gamedashboard.repository.ScoreRepository;
import com.leaderboard.gamedashboard.repository.UserRepository;
import com.leaderboard.gamedashboard.service.ScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScoreServiceImpl  {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private UserRepository userRepository;

//    @Override
//    public ResponseEntity<?> addScore(ScoreDTO scoreDTO) {
//
//        if (scoreDTO == null) {
//            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. Cannot find score details.", false);
//            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
//        }
//        Optional<User> byId = userRepository.findById(scoreDTO.getUserDTO().getId());
//
//        if (!byId.isPresent()) {
//            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. User does not exists.", false);
//            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
//        }
//
//        Score score = new Score();
//        score.setUser(byId.get());
//        score.setDate(new Date());
//        score.setScore(scoreDTO.getScore());
//
//
//        double lastHighScore = byId.get().getHighScore();
//        double newScore = scoreDTO.getScore();
//
//        User user = byId.get();
//        if (newScore > lastHighScore) {
//            user.setHighScore(newScore);
//            userRepository.save(user);
//        }
//
//        Score save = scoreRepository.save(score);
//
//        if (save != null) {
//            ResponseModel res = new ResponseModel(HttpStatus.CREATED.value(), "Score added successfully", true);
//            return new ResponseEntity<>(res, HttpStatus.CREATED);
//        } else {
//            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. Score adding failed.", false);
//            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @Override
//    public ResponseEntity<?> getAllScores() throws Exception {
//        List<ScoreDTO> scoreDTOS = new ArrayList<>();
//
//        List<Score> scores = scoreRepository.findAll();
//
//        if (scores.isEmpty()) {
//            ResponseModel res = new ResponseModel(HttpStatus.NOT_FOUND.value(), "Scores not found. ", false);
//            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
//        }
//
//        for (Score score : scores) {
//
//            ScoreDTO scoreDTO = new ScoreDTO();
//            scoreDTO.setS_id(score.getS_id());
//            scoreDTO.setDate(score.getDate());
//            scoreDTO.setScore(score.getScore());
//
//            User user = score.getUser();
//
//            UserDTO userDTO = new UserDTO();
//            userDTO.setNickName(user.getNickName());
//            userDTO.setGender(user.getGender());
//            userDTO.setId(user.getId());
//            userDTO.setLocation(user.getLocation());
//            userDTO.setMobileNumber(user.getMobileNumber());
//            userDTO.setFb_id(user.getFb_id());
//
//            scoreDTO.setUserDTO(userDTO);
//
//
//            scoreDTOS.add(scoreDTO);
//
//        }
//        return new ResponseEntity<>(scoreDTOS, HttpStatus.OK);
//
//    }


}
