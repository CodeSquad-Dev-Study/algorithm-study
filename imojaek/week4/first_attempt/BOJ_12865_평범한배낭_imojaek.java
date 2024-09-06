package imojaek.week4.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭_imojaek {
    static int n, k;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] backpack = new int[k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= arr[i][0]; j--) {
                if (backpack[j] < backpack[j - arr[i][0]] + arr[i][1])
                    backpack[j] = backpack[j - arr[i][0]] + arr[i][1];
            }
        }
        System.out.println(backpack[k]);
    }
}
