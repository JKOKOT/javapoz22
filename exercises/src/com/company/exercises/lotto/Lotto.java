package com.company.exercises.lotto;

import java.util.*;

public class Lotto {
    public final static int MAX_LOTTO_NUMBERS = 6;
    public final static int MAX_LOTTO_RANGE = 49;

    public static int[] LottoRandomizer() {
        int[] randomInts = new int[MAX_LOTTO_NUMBERS];

        for (int i = 0; i < MAX_LOTTO_NUMBERS; i++) {
            randomInts[i] = getDistinctNumber(randomInts);
        }

        return randomInts;
    }

    private static int getDistinctNumber(int[] ints) {
        Random rand = new Random();
        int number;

        do {
            number = rand.nextInt(49) + 1;
        } while (isValueExists(ints, number));

        return number;
    }

    public static boolean isValueExists(int[] ints, int value) {
        for (int x: ints) {
            if (x == value) {
                return true;
            }
        }
        return false;
    }

    public static int showHitNumbers(int[] userNumbers) {
        int hitCounter = 0;
        int[] ints = LottoRandomizer();
        System.out.println("Wylosowano: " + Arrays.toString(ints));
        for (int x: userNumbers) {
            if (isValueExists(ints, x)) {
                hitCounter++;
                System.out.print(x + ", ");
            }
        }
        System.out.println("Razem trafiłeś " + hitCounter + " razy");
        return hitCounter;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 100000000; i++)  {
//            int[] array = LottoRandomizer();
//            if (showHitNumbers(array) > 5) {
//                System.exit(0);
//            }
//        }


        Scanner scanner = new Scanner(System.in);
        int[] userNumbers = new int[MAX_LOTTO_NUMBERS];

        System.out.println("Podaj "+ MAX_LOTTO_NUMBERS +" różnych liczb od 1-" + MAX_LOTTO_RANGE + ".");
        for (int i = 1; i <= MAX_LOTTO_NUMBERS; i++) {
            try {
                System.out.print("Podaj " + i + " liczbę: ");
                int number = scanner.nextInt();
                if (number < 1 || number >= MAX_LOTTO_RANGE)
                    throw new NumberOutOfRange("Liczba musi być z przedziału 1-"+ (MAX_LOTTO_RANGE - 1) +"\nWybierz inną!!!");
                if (isValueExists(userNumbers, number))
                    throw new NumberExists("Liczba " + number + " była podana wcześniej. \nWybierz inną!!!");
                userNumbers[i - 1] = number;
            } catch (NumberOutOfRange | NumberExists ex) {
                System.out.println(ex.getMessage());
                i--;
            }
        }

        showHitNumbers(userNumbers);
    }
}
