package com.leaderboard.gamedashboard.service.impl;

import com.leaderboard.gamedashboard.dto.ScoreDTO;
import com.leaderboard.gamedashboard.dto.UserDTO;
import com.leaderboard.gamedashboard.model.ResponseModel;
import com.leaderboard.gamedashboard.model.Score;
import com.leaderboard.gamedashboard.model.User;
import com.leaderboard.gamedashboard.repository.ScoreRepository;
import com.leaderboard.gamedashboard.repository.UserRepository;
import com.leaderboard.gamedashboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private String facebookId;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private RestTemplateBuilder restTemplate;


    @Override
    public ResponseEntity<?> save(UserDTO userDTO) throws Exception {

        if (userDTO == null) {
            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. Cannot find user details.", false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setNickName(userDTO.getNickName());
        user.setGender(userDTO.getGender());
        user.setLocation(userDTO.getLocation());
        user.setMobileNumber(userDTO.getMobileNumber());
        user.setFb_id(userDTO.getFb_id());

        ScoreDTO scoreDTO = userDTO.getScoreDTOS().get(0);
        Score score = new Score();
        score.setDate(new Date());
        score.setScore(scoreDTO.getScore());

        user.setHighScore(scoreDTO.getScore());

        User save = userRepository.save(user);

        score.setUser(save);

        Score save1 = scoreRepository.save(score);


        if (save != null && save1 != null) {
            ResponseModel res = new ResponseModel(HttpStatus.CREATED.value(), "User saved successfully", true);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } else {
            ResponseModel res = new ResponseModel(HttpStatus.BAD_REQUEST.value(), "Error. User saving failed.", false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> getById(long u_id) throws Exception {
        Optional<User> user1 = userRepository.findById(u_id);

        if (user1.isPresent()) {
            User user = user1.get();

            UserDTO userDTO = new UserDTO();
            userDTO.setNickName(user.getNickName());
            userDTO.setGender(user.getGender());
            userDTO.setId(user.getId());
            userDTO.setLocation(user.getLocation());
            userDTO.setMobileNumber(user.getMobileNumber());
            userDTO.setFb_id(user.getFb_id());
            userDTO.setHighScore(user.getHighScore());

            List<Score> scores = user.getScores();
            List<ScoreDTO> scoreDTOS = new ArrayList<>();

            for (Score score : scores) {

                ScoreDTO scoreDTO = new ScoreDTO();
                scoreDTO.setId(score.getId());
                scoreDTO.setDate(score.getDate());
                scoreDTO.setScore(score.getScore());

                scoreDTOS.add(scoreDTO);

            }
            userDTO.setScoreDTOS(scoreDTOS);

            return new ResponseEntity<>(userDTO, HttpStatus.OK);

        } else {
            ResponseModel res = new ResponseModel(HttpStatus.NOT_FOUND.value(), "User does not exists. ", false);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> getByGender(String gender) throws Exception {

        List<UserDTO> userDTOS = new ArrayList<>();

        List<User> users = userRepository.getByGender(gender);

        if (users.isEmpty()) {
            ResponseModel res = new ResponseModel(HttpStatus.NOT_FOUND.value(), "User details unavailable. ", false);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        for (User user : users) {

            UserDTO userDTO = new UserDTO();
            userDTO.setNickName(user.getNickName());
            userDTO.setGender(user.getGender());
            userDTO.setId(user.getId());
            userDTO.setLocation(user.getLocation());
            userDTO.setMobileNumber(user.getMobileNumber());
            userDTO.setFb_id(user.getFb_id());
            userDTO.setHighScore(user.getHighScore());

            List<Score> scores = user.getScores();
            List<ScoreDTO> scoreDTOS = new ArrayList<>();

            for (Score score : scores) {

                ScoreDTO scoreDTO = new ScoreDTO();
                scoreDTO.setId(score.getId());
                scoreDTO.setDate(score.getDate());
                scoreDTO.setScore(score.getScore());

                scoreDTOS.add(scoreDTO);

            }

            userDTO.setScoreDTOS(scoreDTOS);

            userDTOS.add(userDTO);

        }
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<?> getByNickName(String nickName) throws Exception {
        Optional<User> user1 = userRepository.getByNickName(nickName);

        if (user1.isPresent()) {
            User user = user1.get();

            UserDTO userDTO = new UserDTO();
            userDTO.setNickName(user.getNickName());
            userDTO.setGender(user.getGender());
            userDTO.setId(user.getId());
            userDTO.setLocation(user.getLocation());
            userDTO.setMobileNumber(user.getMobileNumber());
            userDTO.setFb_id(user.getFb_id());
            userDTO.setHighScore(user.getHighScore());

            List<Score> scores = user.getScores();
            List<ScoreDTO> scoreDTOS = new ArrayList<>();

            for (Score score : scores) {

                ScoreDTO scoreDTO = new ScoreDTO();
                scoreDTO.setId(score.getId());
                scoreDTO.setDate(score.getDate());
                scoreDTO.setScore(score.getScore());

                scoreDTOS.add(scoreDTO);

            }
            userDTO.setScoreDTOS(scoreDTOS);


            return new ResponseEntity<>(userDTO, HttpStatus.OK);

        } else {
            ResponseModel res = new ResponseModel(HttpStatus.NOT_FOUND.value(), "User details unavailable. ", false);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> getByMobileNumber(String mobileNumber) throws Exception {
        Optional<User> user1 = userRepository.getByMobileNumber(mobileNumber);

        if (user1.isPresent()) {
            User user = user1.get();

            UserDTO userDTO = new UserDTO();
            userDTO.setNickName(user.getNickName());
            userDTO.setGender(user.getGender());
            userDTO.setId(user.getId());
            userDTO.setLocation(user.getLocation());
            userDTO.setMobileNumber(user.getMobileNumber());
            userDTO.setFb_id(user.getFb_id());
            userDTO.setHighScore(user.getHighScore());

            List<Score> scores = user.getScores();
            List<ScoreDTO> scoreDTOS = new ArrayList<>();

            for (Score score : scores) {

                ScoreDTO scoreDTO = new ScoreDTO();
                scoreDTO.setId(score.getId());
                scoreDTO.setDate(score.getDate());
                scoreDTO.setScore(score.getScore());

                scoreDTOS.add(scoreDTO);

            }
            userDTO.setScoreDTOS(scoreDTOS);


            return new ResponseEntity<>(userDTO, HttpStatus.OK);

        } else {
            ResponseModel res = new ResponseModel(HttpStatus.NOT_FOUND.value(), "User details unavailable. ", false);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> getByLocation(String location) throws Exception {

        List<UserDTO> userDTOS = new ArrayList<>();

        List<User> users = userRepository.getByLocation(location);

        if (users.isEmpty()) {
            ResponseModel res = new ResponseModel(HttpStatus.NOT_FOUND.value(), "User details unavailable. ", false);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        for (User user : users) {

            UserDTO userDTO = new UserDTO();
            userDTO.setNickName(user.getNickName());
            userDTO.setGender(user.getGender());
            userDTO.setId(user.getId());
            userDTO.setLocation(user.getLocation());
            userDTO.setMobileNumber(user.getMobileNumber());
            userDTO.setFb_id(user.getFb_id());
            userDTO.setHighScore(user.getHighScore());

            List<Score> scores = user.getScores();
            List<ScoreDTO> scoreDTOS = new ArrayList<>();

            for (Score score : scores) {

                ScoreDTO scoreDTO = new ScoreDTO();
                scoreDTO.setId(score.getId());
                scoreDTO.setDate(score.getDate());
                scoreDTO.setScore(score.getScore());

                scoreDTOS.add(scoreDTO);

            }

            userDTO.setScoreDTOS(scoreDTOS);

            userDTOS.add(userDTO);
        }
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAll() throws Exception {
        List<UserDTO> userDTOS = new ArrayList<>();

        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            ResponseModel res = new ResponseModel(HttpStatus.NOT_FOUND.value(), "User details unavailable. ", false);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        for (User user : users) {

            UserDTO userDTO = new UserDTO();
            userDTO.setNickName(user.getNickName());
            userDTO.setGender(user.getGender());
            userDTO.setId(user.getId());
            userDTO.setLocation(user.getLocation());
            userDTO.setMobileNumber(user.getMobileNumber());
            userDTO.setFb_id(user.getFb_id());
            userDTO.setHighScore(user.getHighScore());

            List<Score> scores = user.getScores();
            List<ScoreDTO> scoreDTOS = new ArrayList<>();

            for (Score score : scores) {

                ScoreDTO scoreDTO = new ScoreDTO();
                scoreDTO.setId(score.getId());
                scoreDTO.setDate(score.getDate());
                scoreDTO.setScore(score.getScore());

                scoreDTOS.add(scoreDTO);

            }

            userDTO.setScoreDTOS(scoreDTOS);

            userDTOS.add(userDTO);

        }
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);


    }

    @Override
    public ResponseEntity<?> getFbProfilePic(long u_id) throws Exception {
        Optional<User> byId = userRepository.findById(u_id);

        if (byId.isPresent()) {

            this.facebookId = byId.get().getFb_id();

            String fb_url = "http://graph.facebook.com/" + facebookId + "/picture?type=large";

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<byte[]> response = restTemplate.build().exchange(fb_url, HttpMethod.GET, entity, byte[].class);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } else {
            ResponseModel res = new ResponseModel(HttpStatus.NOT_FOUND.value(), "User details unavailable. ", false);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<?> getAllFbProfileIds() {
        List<User> all = userRepository.findAll();

        List<UserDTO> userDTOS = new ArrayList<>();

        if (all.isEmpty()) {
            ResponseModel res = new ResponseModel(HttpStatus.NOT_FOUND.value(), "User details unavailable. ", false);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        for (User user : all) {


            if (user.getFb_id() != null) {
                UserDTO userDTO = new UserDTO();
                userDTO.setNickName(user.getNickName());
                userDTO.setGender(user.getGender());
                userDTO.setId(user.getId());
                userDTO.setLocation(user.getLocation());
                userDTO.setMobileNumber(user.getMobileNumber());
                userDTO.setFb_id(user.getFb_id());
                userDTO.setHighScore(user.getHighScore());

                userDTOS.add(userDTO);
            }

        }
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> getByGenderAndLocation(String gender, String location) throws Exception {
        List<UserDTO> userDTOS = new ArrayList<>();

        List<User> users = userRepository.getByGenderAndLocation(gender, location);

        if (users.isEmpty()) {
            ResponseModel res = new ResponseModel(HttpStatus.NOT_FOUND.value(), "User details unavailable. ", false);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        for (User user : users) {

            UserDTO userDTO = new UserDTO();
            userDTO.setNickName(user.getNickName());
            userDTO.setGender(user.getGender());
            userDTO.setId(user.getId());
            userDTO.setLocation(user.getLocation());
            userDTO.setMobileNumber(user.getMobileNumber());
            userDTO.setFb_id(user.getFb_id());

            List<Score> scores = user.getScores();
            List<ScoreDTO> scoreDTOS = new ArrayList<>();

            for (Score score : scores) {

                ScoreDTO scoreDTO = new ScoreDTO();
                scoreDTO.setId(score.getId());
                scoreDTO.setDate(score.getDate());
                scoreDTO.setScore(score.getScore());

                scoreDTOS.add(scoreDTO);

            }

            userDTO.setScoreDTOS(scoreDTOS);

            userDTOS.add(userDTO);

        }
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllUserHighScore(int limit) throws Exception {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userRepository.getAllUserHighScore().subList(0, limit);
        if (users.isEmpty()) {
            ResponseModel res = new ResponseModel(HttpStatus.NOT_FOUND.value(), "User details unavailable. ", false);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        for (User user : users) {

            UserDTO userDTO = new UserDTO();
            userDTO.setNickName(user.getNickName());
            userDTO.setGender(user.getGender());
            userDTO.setId(user.getId());
            userDTO.setLocation(user.getLocation());
            userDTO.setMobileNumber(user.getMobileNumber());
            userDTO.setFb_id(user.getFb_id());
            userDTO.setHighScore(user.getHighScore());


            userDTOS.add(userDTO);

        }
        return new ResponseEntity<>(userDTOS, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> deleteUser(String mobileNumber) {
        Optional<User> byMobileNumber = userRepository.getByMobileNumber(mobileNumber);

        if (!byMobileNumber.isPresent()) {
            ResponseModel res = new ResponseModel(HttpStatus.NOT_FOUND.value(), "User does not exists. ", false);
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
        User user = byMobileNumber.get();

        userRepository.delete(user);

        ResponseModel res = new ResponseModel(HttpStatus.OK.value(), "User data removed", true);
        return new ResponseEntity<>(res, HttpStatus.OK);


    }


}
