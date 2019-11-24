package com.company.exercises;

public class Main {

    public static void main(String[] args) {
//        pojazd();
//        firma();
        circle();
    }

    private static void circle() {
        // Polimorfizm, bo używamy typu Shape:
        Shape circle = new Circle(5);
        Shape circle2 = new Circle("czerwony", 3);
        Shape rectangle = new Rectangle("niebieski", 5);

        printDetails(circle);
        printDetails(circle2);
        printDetails(rectangle);
    }

    private static void printDetails(Shape shape) {
        System.out.println(shape.getArea());
        System.out.println(shape.getLineColor());
    }

    private static void firma() {
        Pracownik p1 = new Pracownik("Marcin", "Budziński", 31);
        Pracownik p2 = new Pracownik("Franek", "Nowak", 33);
        Pracownik p3 = new Pracownik("Franek", "Nowak", 33);
        Pracownik p4 = new Pracownik("Franek", "Nowak", 33);
        Pracownik p5 = new Pracownik("Franek", "Nowak", 33);

        Firma firma = new Firma("InsMedia", p1, p2, p3, p4, p5);
        Firma firma2 = new Firma("MM", p1, p5);
        System.out.println(firma);
        System.out.println(firma2);
    }

    private static void pojazd() {
        Pojazd car = new Pojazd(4, "czerwony", 200);
        Pojazd car2 = new Pojazd(4, "zielony");
        System.out.println(car);
        System.out.println(car2);
    }
}


