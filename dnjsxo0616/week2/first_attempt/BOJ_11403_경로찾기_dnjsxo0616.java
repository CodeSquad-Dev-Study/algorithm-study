package dnjsxo0616.week2.first_attempt;

import java.util.Scanner;

public class BOJ_11403_경로찾기_dnjsxo0616 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
