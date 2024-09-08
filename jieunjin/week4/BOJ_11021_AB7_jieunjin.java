package jieunjin.week4;

import java.util.Scanner;

public class BOJ_11021_AB7_jieunjin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        int n = sc.nextInt();
        int a = 0;
        int b = 0;
        int array[] = new int[n];

        for (i = 0; i < n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            array[i] = a + b;
        }

        for (i = 0; i < n; i++) {
            System.out.print("Case #");
            System.out.println((i + 1) + ": " + array[i]);
        }

    }
}

