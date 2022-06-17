package algorithms.recursion_and_backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class GeneratingByteVectors {
    public static int[] bites;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bitesCount = Integer.parseInt(sc.nextLine());

        bites = new int[bitesCount];

        genBites(0);
    }

    public static void genBites(int index) {
        if (index == bites.length - 1) {
            return;
        }

        for (int i = 0; i <= 1; i++) {
            bites[index] = i;
            print();
            genBites(index + 1);
        }
    }

    public static void print() {
        Arrays.stream(bites)
                .forEach(System.out::print);

        System.out.println();
    }
}
