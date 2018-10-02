package com.leaderboard.gamedashboard.controller;

import com.leaderboard.gamedashboard.dto.UserDTO;
import com.leaderboard.gamedashboard.exception.CustomException;
import com.leaderboard.gamedashboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) {
        try {
            return userService.save(userDTO);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to save user. Operation unsuccessful");
        }
    }

    @GetMapping("get-by-gender/{gender}")
    public ResponseEntity<?> getByGender(@PathVariable String gender) {
        try {
            return userService.getByGender(gender);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed fetch data. Operation unsuccessful");
        }
    }

    @GetMapping("get-by-id/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        try {
            return userService.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed fetch data. Operation unsuccessful");
        }
    }

    @GetMapping("get-by-nickname/{nickName}")
    public ResponseEntity<?> getByNickName(@PathVariable String nickName) {
        try {
            return userService.getByNickName(nickName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed fetch data. Operation unsuccessful");
        }
    }

    @GetMapping("get-by-mobile-num/{mobileNumber}")
    public ResponseEntity<?> getByMobileNumber(@PathVariable String mobileNumber) {
        try {
            return userService.getByMobileNumber(mobileNumber);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed fetch data. Operation unsuccessful");
        }
    }

    @GetMapping("get-by-location/{location}")
    public ResponseEntity<?> getByLocation(@PathVariable String location) {
        try {
            return userService.getByLocation(location);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed fetch data. Operation unsuccessful");
        }
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        try {
            return userService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed fetch data. Operation unsuccessful");
        }
    }

    @GetMapping("get-fb-pp/{u_id}")
    public ResponseEntity<?> getFbProfilePic(@PathVariable long u_id) {
        try {
            return userService.getFbProfilePic(u_id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed fetch data. Operation unsuccessful");
        }
    }

    @GetMapping("get-fb-ids")
    public ResponseEntity<?> getAllFbIds() {
        try {
            return userService.getAllFbProfileIds();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed fetch data. Operation unsuccessful");
        }
    }

    @GetMapping("get-by-gender-n-location/{gender}/{location}")
    public ResponseEntity<?> getByGenderAndLocation(@PathVariable String gender, @PathVariable String location) {
        try {
            return userService.getByGenderAndLocation(gender, location);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed fetch data. Operation unsuccessful");
        }
    }

    @DeleteMapping("remove-user/{mobileNumber}")
    public ResponseEntity<?> removeUser(@PathVariable String mobileNumber ){
        try {
            return userService.deleteUser(mobileNumber);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed to delete data. Operation unsuccessful");
        }
    }


    @GetMapping("get-all-high-score/{limit}")
    public ResponseEntity<?> getAllUserHighScore(@PathVariable int limit) {
        try {
            return userService.getAllUserHighScore(limit);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Failed fetch data. Operation unsuccessful");
        }
    }
}
