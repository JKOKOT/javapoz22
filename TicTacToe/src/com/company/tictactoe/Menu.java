package com.company.tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu<T> {
    ArrayList<T> elements = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void add(T element) {
        elements.add(element);
    }

    public void print() {
        for (int i = 1; i <= elements.size(); i++) {
            System.out.println(i + ". " + elements.get(i - 1));
        }
    }

    public T showAndGetSelected() {
        print();
        return elements.get(scanner.nextInt() - 1);
    }
}
