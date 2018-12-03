package com.wildcodeschool.JurassicPark.JurassicPark.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dinosaur {

    public Dinosaur() {
    }

    public Dinosaur(String race, String color, int nbInPark) {
        this.race = race;
        this.color = color;
        this.nbInPark = nbInPark;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String race;

    private String color;

    private int nbInPark;

    @Override
    public String toString() { 
        return "Dinosaur [id=" + id + ", race=" + race + 
                ", color=" + color + ", nbInPark=" + nbInPark + "]";
    }                    

    public Long getId() {
        return id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNbInPark() {
        return nbInPark;
    }

    public void setNbInPark(int nbInPark) {
        this.nbInPark = nbInPark;
    }    

}