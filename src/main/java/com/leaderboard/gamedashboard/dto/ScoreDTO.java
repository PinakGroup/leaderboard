package com.leaderboard.gamedashboard.dto;

import java.io.Serializable;
import java.util.Date;

public class ScoreDTO implements Serializable {

    private long s_id;
    private String score;
    private Date date;
    private UserDTO userDTO;

    public ScoreDTO() {
    }

    public ScoreDTO(long s_id, String score, Date date, UserDTO userDTO) {
        this.setS_id(s_id);
        this.setScore(score);
        this.setDate(date);
        this.setUserDTO(userDTO);
    }

    @Override
    public String toString() {
        return "ScoreDTO{" +
                "s_id=" + getS_id() +
                ", score=" + getScore() +
                ", date=" + getDate() +
                ", userDTO=" + getUserDTO() +
                '}';
    }



    public String getScore() {
        return score;
    }

    public void setScore(String score) {
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

    public long getS_id() {
        return s_id;
    }

    public void setS_id(long s_id) {
        this.s_id = s_id;
    }
}
