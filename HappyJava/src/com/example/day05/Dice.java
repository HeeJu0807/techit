package com.example.day05;

public class Dice {
    public int face = 6;
    public int eye;

    public void roll() {
        eye = (int)(Math.random()*face) + 1;
    }
}
