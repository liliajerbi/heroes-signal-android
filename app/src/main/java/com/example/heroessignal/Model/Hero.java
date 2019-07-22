package com.example.heroessignal.Model;

public class Hero {

    private String name;
    private int picture;
    private String power;

    public Hero() {
    }

    public Hero(String name, int picture, String power) {
        this.name = name;
        this.picture = picture;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
