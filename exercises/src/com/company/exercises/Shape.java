package com.company.exercises;

public abstract class Shape {
    protected String lineColor;

    public Shape(String lineColor) {
        this.lineColor = lineColor;
    }

    abstract public double getArea();

    public String getLineColor() {
        return lineColor;
    }
}
