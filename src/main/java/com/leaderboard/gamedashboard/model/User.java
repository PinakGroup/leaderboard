package com.leaderboard.gamedashboard.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Column(name = "fb_id")
    private
    String fb_id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nick_name", unique = true, nullable = false)
    private String nickName;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Column(name = "mobile_number", unique = true, nullable = false)
    private String mobileNumber;
    @Column(name = "location")
    private String location;
    @Column(name = "high_score")
    private double highScore;
    @OneToMany(mappedBy = "user")
    private List<Score> scores;

    public User() {
    }

    public User(String fb_id, String nickName, String gender, String mobileNumber, String location, double highScore, List<Score> scores) {
        this.setFb_id(fb_id);
        this.setNickName(nickName);
        this.setGender(gender);
        this.setMobileNumber(mobileNumber);
        this.setLocation(location);
        this.setHighScore(highScore);
        this.setScores(scores);
    }

    @Override
    public String toString() {
        return "User{" +
                "fb_id='" + getFb_id() + '\'' +
                ", id=" + getId() +
                ", nickName='" + getNickName() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", mobileNumber='" + getMobileNumber() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", highScore=" + getHighScore() +
                ", scores=" + getScores() +
                '}';
    }

    public String getFb_id() {
        return fb_id;
    }

    public void setFb_id(String fb_id) {
        this.fb_id = fb_id;
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

    public double getHighScore() {
        return highScore;
    }

    public void setHighScore(double highScore) {
        this.highScore = highScore;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
}
