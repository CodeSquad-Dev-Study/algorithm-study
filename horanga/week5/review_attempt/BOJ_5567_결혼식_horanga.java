package horanga.week5.review_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5567_결혼식_horanga {

    static int n;
    static int m;
    static int[][] arr;
    static boolean[] visited;
    static int count;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];

        arr = new int[n][n];
        visited = new boolean[n];
        StringTokenizer st;
        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        DFS(1, 0);
        System.out.println(count);
    }

    private static void DFS(int i, int depth) {

        if(depth ==3){
            return;
        }
        visited[i]=true;

        for(int j =1; j<n; j++){
            if(!visited[j] && arr[i][j]==1){
                count++;
                DFS(j, depth+1);
            }

        }

    }
}
