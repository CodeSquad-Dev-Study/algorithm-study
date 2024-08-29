package dnjsxo0616.week3.first_attempt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1012_유기농배추_dnjsxo0616 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int t, n, m, k, count;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int s=0; s<t; s++) {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();

            graph = new int[n][m];
            visited = new boolean[n][m];

            for(int i=0; i<k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph[y][x] = 1;
            }

            count = 0;
            for(int j=0; j<n; j++) {
                for(int i=0; i<m; i++) {
                    if(!visited[j][i] && graph[j][i] == 1) {
                        count++;
                        BFS(j, i);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    public static void BFS(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            Node p = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(visited[ny][nx] || graph[ny][nx] == 0) {
                    continue;
                }
                queue.add(new Node(nx, ny));
                visited[ny][nx] = true;
            }
        }
    }
}
