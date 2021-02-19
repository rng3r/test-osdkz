package ru.semenov;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Task2 {

    /*
     *
     *   2. Имеем квадратную матрицу NxN элементов a[N][N]. N нечетное число. Значения в массиве имеют тип int.
     *       Необходимо с помощью кода найти элемент с максимальным значением в закрашенной области
     *        (диагональ и левая верхняя часть от нее).
     *        В качестве иллюстрации массива и области поиска приведем пример:
     *            3 7 2 10 1
     *            6 8 2 9 7
     *            17 15 13 8 12
     *            6 3 1 19 9
     *            7 8 5 1 28
     *        Согласно приведенного примера максимальным значением в закрашенной области будет число
     *        17.
     *        Условия задачи: создаем матрицу 7 x 7 элементов, наполняем случайными числами от -30 до +20
     *        включительно.
     *
     * */


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
