package jonghyeok_97.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1697_숨바꼭질_jonghyeok {

    private static boolean[] visited;
    private static int K;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        N = inputs[0];
        K = inputs[1];

        visited = new boolean[200004];

        bfs(new Position(0, N));
    }

    private static void bfs(Position position) {
        Queue<Position> q = new LinkedList<>();
        q.add(position);
        visited[position.here] = true;

        while (!q.isEmpty()) {
            Position p = q.poll();
            if (p.here == K) {
                System.out.println(p.time);
                break;
            }
            for (int next : new int[]{p.here + 1, p.here - 1, p.here * 2}) {
                if(next < 0 || next > 100000) continue;
                if (visited[next]) continue;
                visited[next] = true;
                q.add(new Position(p.time + 1, next));
            }
        }
    }

    static class Position {
        private int time;
        private int here;

        public Position(int time, int here) {
            this.time = time;
            this.here = here;
        }
    }
}
