package com.leaderboard.gamedashboard.repository;

import com.leaderboard.gamedashboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT d FROM User d WHERE d.gender = :gender")
    List<User> getByGender(@Param("gender") String gender);

    @Query("SELECT d FROM User d WHERE d.nickName = :nickName")
    Optional<User> getByNickName(@Param("nickName") String nickName);

    @Query("SELECT d FROM User d WHERE d.mobileNumber = :mobileNumber")
    Optional<User> getByMobileNumber(@Param("mobileNumber") String mobileNumber);

    @Query("SELECT d FROM User d WHERE d.location = :location")
    List<User> getByLocation(@Param("location") String location);

    @Query("SELECT d FROM User d WHERE d.gender = :gender AND d.location = :location")
    List<User> getByGenderAndLocation(@Param("gender") String gender, @Param("location") String location);

    @Query("select u from  User u order by u.highScore desc ")
    List<User> getAllUserHighScore();

}
