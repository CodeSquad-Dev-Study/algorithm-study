package jieunjin.week7;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1546_평균_jieunjin {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double arr[] = new double[in.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextDouble();
        }
        in.close();

        double sum = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            sum += ((arr[i] / arr[arr.length - 1]) * 100);
        }
        System.out.print(sum / arr.length);
    }
}
