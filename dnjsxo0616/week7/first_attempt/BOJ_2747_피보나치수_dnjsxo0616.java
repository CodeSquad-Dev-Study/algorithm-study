package dnjsxo0616.week7.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2747_피보나치수_dnjsxo0616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] fibo = new int[num+1];
        fibo[0] = 0;
        fibo[1] = 1;

        for(int i=2; i<=num; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        System.out.println(fibo[num]);
    }
}
