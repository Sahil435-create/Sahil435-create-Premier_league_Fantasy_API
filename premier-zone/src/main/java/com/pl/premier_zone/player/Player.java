package com.pl.premier_zone.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_statistic")
public class Player {
    @Id
    @Column(name = "player_name", unique = true)
    private String name;

    private String nation;
    private String position;
    private Integer age;
    private Integer matPlayed;
    private Integer start;
    private Double minPlayed;
    private Double goals;
    private Double assists;
    private Double  penScored;
    private Double yCards;
    private Double rCards;
    private Double expGoals;
    private Double expAssists;
    private String teamName;

    public Player() {
    }

    public Player(String name, String nation, String position, Integer age, Integer matPlayed, Integer start, Double minPlayed, Double goals, Double assists, Double penScored, Double yCards, Double rCards, Double expGoals, Double expAssists, String teamName) {
        this.name = name;
        this.nation = nation;
        this.position = position;
        this.age = age;
        this.matPlayed = matPlayed;
        this.start = start;
        this.minPlayed = minPlayed;
        this.goals = goals;
        this.assists = assists;
        this.penScored = penScored;
        this.yCards = yCards;
        this.rCards = rCards;
        this.expGoals = expGoals;
        this.expAssists = expAssists;
        this.teamName = teamName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMatPlayed() {
        return matPlayed;
    }

    public void setMatPlayed(Integer matPlayed) {
        this.matPlayed = matPlayed;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Double getMinPlayed() {
        return minPlayed;
    }

    public void setMinPlayed(Double minPlayed) {
        this.minPlayed = minPlayed;
    }

    public Double getGoals() {
        return goals;
    }

    public void setGoals(Double goals) {
        this.goals = goals;
    }

    public Double getAssists() {
        return assists;
    }

    public void setAssists(Double assists) {
        this.assists = assists;
    }

    public Double getPenScored() {
        return penScored;
    }

    public void setPenScored(Double penScored) {
        this.penScored = penScored;
    }

    public Double getyCards() {
        return yCards;
    }

    public void setyCards(Double yCards) {
        this.yCards = yCards;
    }

    public Double getrCards() {
        return rCards;
    }

    public void setrCards(Double rCards) {
        this.rCards = rCards;
    }

    public Double getExpGoals() {
        return expGoals;
    }

    public void setExpGoals(Double expGoals) {
        this.expGoals = expGoals;
    }

    public Double getExpAssists() {
        return expAssists;
    }

    public void setExpAssists(Double expAssists) {
        this.expAssists = expAssists;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
