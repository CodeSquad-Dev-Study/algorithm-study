package dnjsxo0616.week3.first_attempt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178_미로탐색_dnjsxo0616 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String line = sc.nextLine();
            for(int j=0; j<m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        BFS(0, 0);


        System.out.print(graph[n-1][m-1]);
    }

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            int currentY = p.y;
            int currentX = p.x;

            for(int i=0; i<4; i++) {
                int ny = currentY + dy[i];
                int nx = currentX + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if(visited[ny][nx] || graph[ny][nx] == 0) {
                    continue;
                }
                queue.add(new Point(nx, ny));
                graph[ny][nx] = graph[p.y][p.x] + 1;
                visited[ny][nx] = true;
            }
        }
    }
}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
