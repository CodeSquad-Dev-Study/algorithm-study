package week12.review_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로_탐색_seondays {

    static int[][] graph;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf)
                    .toArray();
            graph[i] = line;
        }

        bfs();
    }

    static void bfs() {
        int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[101][101];
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] thisTurn = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = thisTurn[0] + direction[i][0];
                int nextY = thisTurn[1] + direction[i][1];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
                    continue;
                }

                if (graph[nextX][nextY] != 0 && !visit[nextX][nextY]) {
                    graph[nextX][nextY] = graph[thisTurn[0]][thisTurn[1]] + 1;
                    queue.add(new int[]{nextX, nextY});
                    visit[nextX][nextY] = true;
                }
            }
        }
        System.out.println(graph[n - 1][m - 1]);
    }
}
