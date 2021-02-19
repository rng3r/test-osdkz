package ru.semenov;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test3 {


    /*
    *
    *
    *
    *
    *
    * */


    public static void main(String[] args) {


        int[] array = IntStream.rangeClosed(0, 9).toArray();



        for (int shift = 0; shift < 15; shift++) {

            System.out.println("original = " + Arrays.toString(array));
            System.out.println("shift =" + shift);
            int[] shifted = rotate(shift, true, array);
            System.out.println("rotate right = " + Arrays.toString(shifted));
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

        }

        for (int shift = 0; shift < 15; shift++) {

            System.out.println("original = " + Arrays.toString(array));
            System.out.println("shift =" + shift);
            int[] shifted = rotate(shift, false, array);
            System.out.println("rotate left = " + Arrays.toString(shifted));
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

        }



    }

    private static int[] rotate(int shift, boolean isRight, int[] source) {

        int sourceLength = source.length;

        int[] shifted = new int[sourceLength];

        shift = shift < sourceLength ? shift : shift % sourceLength;
        shift = isRight ? shift : -shift;

        for (int i = 0; i < sourceLength; i++) {

            int sourceElement = source[i];
            int iPlusShift = i + shift;
            iPlusShift = iPlusShift < 0 ? sourceLength + iPlusShift : iPlusShift;
            int newIdx = (iPlusShift < sourceLength) ? iPlusShift : Math.abs(sourceLength - iPlusShift);
            shifted[newIdx] = sourceElement;

        }
        return shifted;

    }

}
