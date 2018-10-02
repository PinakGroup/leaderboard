package com.leaderboard.gamedashboard.dto;

import java.io.Serializable;
import java.util.Date;

public class ScoreDTO implements Serializable {

    private long id;
    private double score;
    private Date date;
    private UserDTO userDTO;

    public ScoreDTO() {
    }

    public ScoreDTO(long id, double score, Date date, UserDTO userDTO) {
        this.setId(id);
        this.setScore(score);
        this.setDate(date);
        this.setUserDTO(userDTO);
    }

    @Override
    public String toString() {
        return "ScoreDTO{" +
                "id=" + getId() +
                ", score=" + getScore() +
                ", date=" + getDate() +
                ", userDTO=" + getUserDTO() +
                '}';
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
