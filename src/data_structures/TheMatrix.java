package data_structures;

import java.util.*;

public class TheMatrix {
    static Scanner console = new Scanner(System.in);
    static String[][] matrix;
    static int rows, cols;
    static String changeSymbol;
    static String symbolToReplace;
    static Map<Integer, Integer> visitedPositions = new HashMap<>();

    public static void main(String[] args) {
        int[] matrixSize = Arrays.stream(console.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        rows = matrixSize[0];
        cols = matrixSize[1];

        matrix = new String[rows][cols];
        readMatrix();
        changeSymbol = console.nextLine();

        int[] positions = Arrays.stream(console.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rowPos = positions[0];
        int colPos = positions[1];

        symbolToReplace = matrix[rowPos][colPos];

        fillMatrix(rowPos, colPos);
        printMatrix();
    }

    private static void fillMatrix(int rowPos, int colPos) {
        if (!isInBounds(rowPos, colPos)) {
            return;
        }

        if (visitedPositions.containsKey(rowPos)) {
            if (visitedPositions.get(rowPos) == colPos) {
                return;
            }
        }

        if (!matrix[rowPos][colPos].equals(symbolToReplace)) {
            return;
        }

        matrix[rowPos][colPos] = changeSymbol;
        visitedPositions.put(rowPos, colPos);

        fillMatrix(rowPos + 1, colPos);
        fillMatrix(rowPos, colPos + 1);
        fillMatrix(rowPos - 1, colPos);
        fillMatrix(rowPos, colPos - 1);
    }

    private static boolean isInBounds(int rowPos, int colPos) {
        return rowPos >= 0 && rowPos < rows && colPos >= 0 && colPos < cols;
    }

    private static void readMatrix() {
        for (int i = 0; i < rows; i++) {
            matrix[i] = console.nextLine().split(" ");
        }
    }

    private static void printMatrix() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }
}
