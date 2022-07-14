package algorithms.recursion_backtracking_combinatorics;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ForLoopsToRecursion {
    public static int[] arr;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int limit = Integer.parseInt(console.nextLine());
        arr = new int[limit];

        imitateForLoops(0);
    }

    private static void imitateForLoops(int index) {
        if (index == arr.length) {
            print();
            return;
        }

        for (int i = 1; i <= arr.length; i++) {
            arr[index] = i;
            imitateForLoops(index + 1);
        }
    }

    public static void print() {
        String arr = Arrays.stream(ForLoopsToRecursion.arr)
                .mapToObj(Objects::toString)
                .collect(Collectors.joining(" "));
        System.out.println(arr);
    }
}
