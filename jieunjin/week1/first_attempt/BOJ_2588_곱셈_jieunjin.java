package jieunjin.week1.first_attempt;

import java.util.Scanner;

public class BOJ_2588_곱셈_jieunjin {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int hundreds = b / 100;
        int tens = (b / 10) % 10;
        int ones = b % 10;

        int A = a * ones;
        int B = a * tens;
        int C = a * hundreds;
        int total = A + (B * 10) + (C *100);

        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(total);


        }
    }

