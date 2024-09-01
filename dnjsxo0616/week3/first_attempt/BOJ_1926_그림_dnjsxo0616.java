package dnjsxo0616.week3.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926_그림_dnjsxo0616 {
    static int[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int n, m, max, num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(tk.nextToken());
        m = Integer.parseInt(tk.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            tk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        max = 0;
        num = 0;

        // 그래프 탐색
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 1 && !visited[i][j]) {
                    num++;
                    visited[i][j] = true;
                    int area = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] {i, j});

                    while(!queue.isEmpty()) {
                        area++;
                        int[] current = queue.poll();
                        int x = current[0];
                        int y = current[1];

                        for(int dir = 0; dir < 4; dir++) {
                            int nx = x + dx[dir];
                            int ny = y + dy[dir];

                            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                            if(visited[nx][ny] || graph[nx][ny] != 1) continue;

                            visited[nx][ny] = true;
                            queue.offer(new int[] {nx, ny});
                        }
                    }

                    max = Math.max(max, area);
                }
            }
        }

        System.out.println(num);
        System.out.println(max);
    }
}
