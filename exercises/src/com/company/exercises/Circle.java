package com.company.exercises;

public class Circle extends Shape {
    private double r;

    public Circle(double r) {
        super("czarny");
        this.r = r;
    }

    public Circle(String lineColor, double r) {
        super(lineColor);
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(r, 2);
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
}
