package imojaek.week3.first_attempt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576_토마토_imojaek {
    static int n;
    static int m;

    static int[][] map;
    static int[][] isVisited;
    static Queue<Point> queue = new LinkedList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[m][n];
        isVisited = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        bfs();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, map[i][j]);
            }
        }
        System.out.println(result - 1);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void bfs() {
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            isVisited[currentX][currentY] = 1;

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && isVisited[nextX][nextY] == 0 && map[nextX][nextY] == 0) {
                    queue.add(new Point(nextX, nextY));
                    map[nextX][nextY] = map[currentX][currentY] + 1;
                    isVisited[nextX][nextY] = 1;
                }
            }
        }
    }
}
