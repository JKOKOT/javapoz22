package com.company.exercises;

public class Firma {
    private String name;
    private Pracownik[] employee;

    public Firma(String name, Pracownik... employee) {
        this.name = name;
        this.employee = employee;
    }

    @Override
    public String toString() {
        String result = "Nazwa firmy: " + name + "\nPracownicy:\n";

        /*
        for (Pracownik xxx: employee) jest to odpowienik:

        for (int i = 0; i < employee.length; i++) {
            result += "* " + employee[i] + "\n";
        }
        */

        for (Pracownik emplo: employee) {
            result += "* " + emplo + "\n";
        }
        
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }
}
