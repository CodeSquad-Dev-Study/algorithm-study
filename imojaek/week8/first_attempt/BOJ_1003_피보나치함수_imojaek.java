package imojaek.week8.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수_imojaek {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Fib[] fibArr = new Fib[41];
        fibArr[0] = new Fib(1, 0);
        fibArr[1] = new Fib(0, 1);

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = 2; j < n + 1; j++) {
                fibArr[j] = new Fib(fibArr[j - 1].zero + fibArr[j - 2].zero, fibArr[j - 1].one + fibArr[j - 2].one);
            }
            System.out.println(fibArr[n].zero + " " + fibArr[n].one);
        }
    }

    public static class Fib {
        public int zero;
        public int one;

        public Fib(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }
}
