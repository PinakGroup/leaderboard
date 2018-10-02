package com.leaderboard.gamedashboard.service;

import com.leaderboard.gamedashboard.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> save(UserDTO userDTO) throws Exception;

    ResponseEntity<?> getById(long u_id) throws Exception;

    ResponseEntity<?> getByGender(String gender) throws Exception;

    ResponseEntity<?> getByNickName(String nickName) throws Exception;

    ResponseEntity<?> getByMobileNumber(String mobileNumber) throws Exception;

    ResponseEntity<?> getByLocation(String location) throws Exception;

    ResponseEntity<?> getAll() throws Exception;

    ResponseEntity<?> getFbProfilePic(long u_id) throws Exception;

    ResponseEntity<?> getAllFbProfileIds();

    ResponseEntity<?> getByGenderAndLocation(String gender, String location) throws Exception;

    ResponseEntity<?> getAllUserHighScore(int limit) throws Exception;

    ResponseEntity<?> deleteUser(String mobileNumber);

}
