package com.company.exercises;

public class Rectangle extends Shape {
    private double a;

    public Rectangle(String lineColor, double a) {
        super(lineColor);
        this.a = a;
    }

    @Override
    public double getArea() {
        return a*a;
    }
}
