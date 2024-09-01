package jonghyeok_97.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2720_세탁소사장동혁_jonghyeok {

    private static int quarter = 25;
    private static int dime = 10;
    private static int nickel = 5;
    private static int penny = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int i = Integer.parseInt(br.readLine());

            int qCount = i / quarter;
            System.out.print(qCount + " ");
            i %= quarter;

            int dCount = i / dime;
            i %= dime;
            System.out.print(dCount + " ");

            int nCount = i / nickel;
            i %= nickel;
            System.out.print(nCount + " ");

            int pCount = i / penny;
            i %= penny;
            System.out.print(pCount + " ");
        }
    }
}
