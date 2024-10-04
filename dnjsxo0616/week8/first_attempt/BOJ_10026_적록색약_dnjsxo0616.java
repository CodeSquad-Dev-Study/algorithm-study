package dnjsxo0616.week8.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약_dnjsxo0616 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n;
    static boolean[][] visited;
    static Character[][] map1;
    static Character[][] map2;
    static Queue<Point> queue = new LinkedList<>();
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map1 = new Character[n][n];
        map2 = new Character[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String input = br.readLine();
            for(int j=0; j<n; j++) {
                char c = input.charAt(j);
                map1[i][j] = c;
                if(c == 'R' || c == 'G'){
                    map2[i][j] = 'R';
                } else map2[i][j] = c;
            }
        }
        int count1 =0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    BFS(j, i, map1);
                    count1++;
                }
            }
        }

        visited = new boolean[n][n];
        int count2 = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]) {
                    BFS(j, i, map2);
                    count2++;
                }
            }
        }
        System.out.print(count1 + " " + count2);
    }
    public static void BFS(int x, int y, Character[][] map) {
        Character c = map[y][x];
        queue.offer(new Point(x, y));
        visited[y][x] = true;
        while(!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if(!visited[ny][nx] && map[ny][nx].equals(c)) {
                        queue.offer(new Point(nx, ny));
                        visited[ny][nx] = true;
                    }
                }
            }
        }
    }
}
