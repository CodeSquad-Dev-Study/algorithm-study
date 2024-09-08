package jieunjin.week4;

import java.util.Scanner;

public class BOJ_8393_합_jieunjin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= a; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

}
