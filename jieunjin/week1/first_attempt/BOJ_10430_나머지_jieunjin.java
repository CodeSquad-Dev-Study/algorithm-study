package jieunjin.week1.first_attempt;

import java.util.Scanner;

public class BOJ_10430_나머지_jieunjin {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        System.out.println((A + B) % C);
        System.out.println(((A % C) + (B % C)) % C);
        System.out.println((A * B) % C);
        System.out.println(((A % C) * (B % C)) % C);

    }
}

