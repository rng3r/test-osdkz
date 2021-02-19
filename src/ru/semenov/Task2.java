package ru.semenov;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Task2 {

    private static final int[][] ARRAY = new int[7][7];

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        int[] flatArray = RANDOM.ints(49, -30, 20).toArray();
        System.out.println("flat array = " + Arrays.toString(flatArray));

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                ARRAY[i][j] = flatArray[i * 7 + j];
            }
        }


        StringBuilder matrixOutput = new StringBuilder();
        for (int i = 0; i < ARRAY.length; i++) {


            for (int j = 0; j < ARRAY[i].length; j++) {

                matrixOutput.append(ARRAY[i][j]).append("\t");

            }

            matrixOutput.append("\n");

        }
        System.out.println(matrixOutput.toString());

        int max = max(ARRAY);


        System.out.println("result = " + max);

    }


    private static int max(int[][] matrix) {

        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i < matrix.length; i++) {
            for (int j = 0 ; j < (matrix[i].length - i); j++) {
                    if (max < matrix[i][j])
                        max = matrix[i][j];
            }
        }

        return max;

    }
}
