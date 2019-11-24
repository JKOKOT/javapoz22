package com.company.exercises;

public class Main {

    public static void main(String[] args) {
        pojazd();
    }

    private static void pojazd() {
        Pojazd car = new Pojazd(4, "czerwony", 200);
        Pojazd car2 = new Pojazd(4, "zielony");
        System.out.println(car.toString());
        System.out.println(car2.toString());
    }
}
