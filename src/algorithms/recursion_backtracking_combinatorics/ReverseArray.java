package algorithms.recursion_backtracking_combinatorics;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] array = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        array = reverseArray(array);

        printArr(array);
    }


    private static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        reverse(array, reversed, 0);

        return reversed;
    }

    private static void reverse(int[] array, int[] reversed, int index) {
        if (index == array.length) {
            return;
        }

        reversed[index] = array[array.length - 1 - index];
        reverse(array, reversed, index + 1);
    }

    private static void printArr(int[] array) {
        System.out.println(Arrays.stream(array)
                .mapToObj(Objects::toString)
                .collect(Collectors.joining(" ")));
    }
}
