package dnjsxo0616.week8.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토_dnjsxo0616 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n, m;
    static boolean[][] visited;
    static int[][] map;
    static Queue<Point> queue = new LinkedList<>();
    static class Point {
        int x;
        int y;
        int day;

        public Point(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    queue.offer(new Point(j, i, 0));
                }
            }
        }
        int ans = BFS();
        boolean check = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) {
                    check = true;
                }
            }
        }

        if(!check) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }
    public static int BFS() {
        int day = 0;

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            day = p.day;
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if(map[ny][nx] == 0) {
                        queue.offer(new Point(nx, ny, day+1));
                        map[ny][nx] = 1;
                    }
                }
            }
        }
        return day;
    }
}
