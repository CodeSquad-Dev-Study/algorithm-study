package jieunjin.week7;

import java.util.Scanner;

public class BOJ_27866_문자와문자열_jieunjin {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st = sc.next();
        int n = sc.nextInt()-1;

        System.out.println(st.charAt(n));

        sc.close();
    }

}
