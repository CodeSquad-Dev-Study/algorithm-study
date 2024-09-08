package jieunjin.week4;

import java.util.Scanner;

public class BOJ_25314_체육과목_jieunjin {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        String str = "";
        scan.close();

        for (int i = 1; i <= n / 4; i++) {
            str += "long ";
        }
        System.out.println(str + "int");

    }
}


