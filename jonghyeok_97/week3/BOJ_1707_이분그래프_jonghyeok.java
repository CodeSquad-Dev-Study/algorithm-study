package jonghyeok_97.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1707_이분그래프_jonghyeok {

    private static boolean[] visited;
    private static int[] draw;
    private static List<Integer>[] nodes;
    private static boolean isGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(br.readLine());

        while (testCaseCount-- > 0) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int v = inputs[0];
            int e = inputs[1];

            isGraph = true;
            nodes = new ArrayList[v + 1];
            visited = new boolean[v + 1];
            draw = new int[v + 1];

            for (int i = 1; i <= v; i++) {
                nodes[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                int[] info = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int node1 = info[0];
                int node2 = info[1];
                nodes[node1].add(node2);
                nodes[node2].add(node1);
            }

            for (int i = 1; i <= v; i++) {
                if (!isGraph) {
                    break;
                }
                dfs(i, 1);
            }
            if (!isGraph) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    private static void dfs(int here, int color) {
        if(!visited[here]) {
            draw[here] = color;
            visited[here] = true;
        }
        for (int there : nodes[here]) {
            if (visited[there]) {
                if (draw[here] == draw[there]) {
                    isGraph = false;
                    return;
                }
            } else {
                dfs(there, color == 1 ? 2 : 1);
            }

        }
    }
}
