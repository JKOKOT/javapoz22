package com.company.tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<String> elements = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void add(String element) {
        elements.add(element);
    }

    public void print() {
        for (int i = 1; i <= elements.size(); i++) {
            System.out.println(i + ". " + elements.get(i - 1));
        }
    }

    public String chosenOptions() {
        return elements.get(scanner.nextInt() - 1);
    }
}
