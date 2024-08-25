package horanga.week2.first_attempt;

import java.util.Scanner;

public class BOJ_2606_바이러스_horanga {

    static int count=0;
    static boolean[] visited;
    static int num;
    static int line;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        line = scanner.nextInt();

        int[][] array = new int[num+1][num+1];

        for(int i =0; i<line; i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            array[start][end] = 1;
            array[end][start] =1;
        }

        visited = new boolean[num+1];
        dfs(1, array);
        System.out.println(count-1);

    }

    public static void dfs(int start, int[][] array){
        visited[start] =true;
        count++;

        for(int i =0; i<=num; i++){
            if(array[start][i]==1 && !visited[i]){
                dfs(i, array);
            }
        }
    }
}
