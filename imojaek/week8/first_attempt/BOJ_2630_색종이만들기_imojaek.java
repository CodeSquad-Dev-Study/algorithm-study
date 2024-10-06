package imojaek.week8.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2630_색종이만들기_imojaek {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        Count count = new Count();
        function(arr, 0, 0, N, count);
        System.out.println(count.white);
        System.out.println(count.blue);
    }
    public static void function(int[][] arr, int x, int y, int N, Count count) {
        int sum = 0;
        for (int i = y; i < y + N; i++) {
            for (int j = x; j < x + N; j++) {
                sum += arr[i][j];
            }
        }
        if (sum == N * N) {
            count.blue++;
            return ;
        }
        else if (sum == 0) {
            count.white++;
            return ;
        }

        function(arr, x, y, N / 2, count);
        function(arr, x + N / 2, y, N / 2, count);
        function(arr, x, y + N / 2, N / 2, count);
        function(arr, x + N / 2, y + N / 2, N / 2, count);
    }

    public static class Count {
        int white = 0;
        int blue = 0;
    }
}
