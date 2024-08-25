package dnjsxo0616.week2.first_attempt;

import java.util.Scanner;

public class BOJ_1389_케빈베이컨의6단계법칙_dnjsxo0616 {
    public class Main {

        static int N, M;
        static int[][] rel;
        static final int INF = 999999999;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            N = sc.nextInt();
            M = sc.nextInt();

            rel = new int[N+1][N+1];

            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    rel[i][j] = INF;
                    if(i == j) {
                        rel[i][j] = 0;
                    }
                }
            }

            for(int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                rel[a][b] = 1;
                rel[b][a] = 1;
            }

            for(int k = 1; k <= N; k++) {
                for(int i = 1; i <= N; i++) {
                    for(int j = 1; j <= N; j++) {
                        rel[i][j] = Math.min(rel[i][j], rel[i][k] + rel[k][j]);
                    }
                }
            }

            int temp = INF;
            int result = 0;
            for(int i = 1; i <= N; i++) {
                int total = 0;
                for(int j = 1; j <= N; j++) {
                    total += rel[i][j];
                }

                if(temp > total) {
                    temp = total;
                    result = i;
                }
            }

            System.out.println(result);
        }
    }

}
