package com.leaderboard.gamedashboard.dto;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {
    private long id;
    private String nickName;
    private String gender;
    private String mobileNumber;
    private String location;
    private String fb_id;
    private double highScore;
    private List<ScoreDTO> scoreDTOS;

    public UserDTO() {
    }

    public UserDTO(long id, String nickName, String gender, String mobileNumber, String location, String fb_id, double highScore, List<ScoreDTO> scoreDTOS) {
        this.setId(id);
        this.setNickName(nickName);
        this.setGender(gender);
        this.setMobileNumber(mobileNumber);
        this.setLocation(location);
        this.setFb_id(fb_id);
        this.setHighScore(highScore);
        this.setScoreDTOS(scoreDTOS);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + getId() +
                ", nickName='" + getNickName() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", mobileNumber='" + getMobileNumber() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", fb_id='" + getFb_id() + '\'' +
                ", highScore=" + getHighScore() +
                ", scoreDTOS=" + getScoreDTOS() +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFb_id() {
        return fb_id;
    }

    public void setFb_id(String fb_id) {
        this.fb_id = fb_id;
    }

    public double getHighScore() {
        return highScore;
    }

    public void setHighScore(double highScore) {
        this.highScore = highScore;
    }

    public List<ScoreDTO> getScoreDTOS() {
        return scoreDTOS;
    }

    public void setScoreDTOS(List<ScoreDTO> scoreDTOS) {
        this.scoreDTOS = scoreDTOS;
    }
}
