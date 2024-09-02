package dnjsxo0616.week4.review_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2667_단지번호붙이기_dnjsxo0616 {
    static int n;
    static int[][] graph;
    static int[][] apart;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> ans = new ArrayList<>();
        int area = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && graph[i][j] == 1) {
                    int num = BFS(i, j);
                    ans.add(num);
                    area++;
                }
            }
        }

        System.out.println(area);
        Collections.sort(ans);
        for(int n : ans) {
            System.out.println(n);
        }
    }

    public static int BFS(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        int count = 0;

        while(!queue.isEmpty()) {
            count++;
            int[] p = queue.poll();
            for(int i=0; i<4; i++) {
                int nextX = p[1] + dx[i];
                int nextY = p[0] + dy[i];

                if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                    if(!visited[nextY][nextX] && graph[nextY][nextX] == 1) {
                        queue.offer(new int[]{nextY, nextX});
                        visited[nextY][nextX] = true;
                    }
                }
            }
        }
        return count;
    }
}
