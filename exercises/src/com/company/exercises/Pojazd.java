package com.company.exercises;

public class Pojazd {
    private int wheelCount;
    private String color;
    private float speed = 100;

    public Pojazd(int wheelCount, String color, float speed) {
        this.wheelCount = wheelCount;
        this.color = color;
        this.speed = speed;
    }

    public Pojazd(int wheelCount, String color) {
        this.wheelCount = wheelCount;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pojazd ma " + wheelCount +
                " koła, jest " + color +
                " i może jechać " + speed + "km/h";
    }

}
