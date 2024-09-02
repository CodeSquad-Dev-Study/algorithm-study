package jonghyeok_97.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class BOJ_13265_색칠하기_jonghyeok {

    private static List<Integer>[] nodes;
    private static boolean[] visited;
    private static int[] color;
    private static boolean isGraph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int[] nm = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int n = nm[0];
            int m = nm[1];

            nodes = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            color = new int[n + 1];
            isGraph = true;

            for (int i = 1; i <= n; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                int[] lines = Stream.of(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int a = lines[0];
                int b = lines[1];

                nodes[a].add(b);
                nodes[b].add(a);
            }

            for (int i = 1; i <= n; i++) {
                if(visited[i]) continue;
                if (!isGraph) {
                    break;
                }
                bfs(i);
            }
            System.out.println(isGraph ? "possible" : "impossible");
        }
    }

    private static void bfs(int here) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(here, 1));
        color[here] = 1;
        visited[here] = true;

        while (!q.isEmpty()) {
            Node there = q.poll();

            for (int next : nodes[there.num]) {
                if (!visited[next] && there.color == 1) {
                    q.add(new Node(next, 2));
                    color[next] = 2;
                } else if (!visited[next] && there.color == 2) {
                    q.add(new Node(next, 1));
                    color[next] = 1;
                } else if (visited[next]) {
                    if (there.color == color[next]) {
                        isGraph = false;
                        break;
                    }
                }
                visited[next] = true;
            }
        }
    }

    private static class Node {
        private final int num;
        private final int color;

        public Node(int num, int color) {
            this.num = num;
            this.color = color;
        }
    }
}
