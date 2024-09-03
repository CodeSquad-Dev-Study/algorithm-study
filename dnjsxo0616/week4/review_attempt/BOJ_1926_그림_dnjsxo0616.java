package dnjsxo0616.week4.review_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1926_그림_dnjsxo0616 {
    static int[][] graph;
    static boolean[][] visited;
    static int n, m, count;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int area = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && graph[i][j] == 1) {
                    int bfs = BFS(i, j);
                    ans.add(bfs);
                    area++;
                }
            }
        }

        System.out.println(area);
        int maxNum = ans.isEmpty() ? 0 : Collections.max(ans);
        System.out.println(maxNum);
    }

    public static int BFS(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        count = 0;
        while(!queue.isEmpty()) {
            count++;
            int[] p = queue.poll();
            for(int i=0; i<4; i++) {
                int nextX = p[1] + dx[i];
                int nextY = p[0] + dy[i];

                if(nextY >= 0 && nextX >= 0 && nextY < n && nextX < m) {
                    if(!visited[nextY][nextX] && graph[nextY][nextX] == 1) {
                        visited[nextY][nextX] = true;
                        queue.offer(new int[]{nextY, nextX});
                    }
                }
            }
        }
        return count;
    }
}
