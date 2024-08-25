package horanga.week2.first_attempt;

import java.util.Scanner;

public class BOJ_11724_연결요수의개수_horanga {

    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        visited = new boolean[n+1];

        int[][] array = new int[n+1][n+1];

        for(int i =0; i<m; i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            array[start][end] = 1;
            array[end][start] = 1;
        }


        int result = 0 ;

        for(int i = 1; i <= n; i++) {
            if(visited[i] == false) {
                dfs(array, i);
                result++;
            }
        }

        System.out.println(result);

    }


    private static void dfs(int[][] array, int i) {

        for(int j =0; j<array.length; j++){
            if(array[i][j]==1 &&!visited[j]){
                visited[j]=true;
                dfs(array, j);
            }
        }
    }
}
