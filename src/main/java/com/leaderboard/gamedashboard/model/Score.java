package com.leaderboard.gamedashboard.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long s_id;
    @Column(name = "score")
    private int score;
    @Column(name = "date")
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public Score() {


    }

    public Score(int score, Date date, User user) {
        this.setScore(score);
        this.setDate(date);
        this.setUser(user);
    }

    @Override
    public String toString() {
        return "Score{" +
                "s_id=" + getS_id() +
                ", score=" + getScore() +
                ", date=" + getDate() +
                ", user=" + getUser() +
                '}';
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getS_id() {
        return s_id;
    }

    public void setS_id(long s_id) {
        this.s_id = s_id;
    }
}
