package task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1: Работа с числами");
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        intList.sort(Comparator.naturalOrder());
        for (int number : intList) {
            if (number > 0 && number % 2 == 0) {
                System.out.println(number);
            }
        }
    }
}