package jonghyeok_97.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class BOJ_14500_테트로미노_jonghyeok {

    private static int N;
    private static int M;
    private static int[][] a;
    private static boolean[][] visited;
    private static int MIN = Integer.MIN_VALUE;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N = inputs[0];
        M = inputs[1];
        a = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            int[] lines = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < M; j++) {
                a[i][j] = lines[j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(new Position(i, j), 1, a[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(MIN);
    }

    private static void dfs(Position p, int count, int sum) {
        if (count == 4) {
            MIN = Math.max(MIN, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 | ny >= M || visited[nx][ny]) continue;

            if (count == 2) {
                visited[nx][ny] = true;
                dfs(new Position(p.x, p.y), count + 1, sum + a[nx][ny]);
                visited[nx][ny] = false;
            }
            visited[nx][ny] = true;
            dfs(new Position(nx, ny), count + 1, sum + a[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    private static class Position {
        private final int x;
        private final int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
