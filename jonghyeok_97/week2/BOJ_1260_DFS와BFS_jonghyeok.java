package jonghyeok_97.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_1260_DFS와BFS_jonghyeok {

    private static List<Integer>[] nodes;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int V = Integer.parseInt(firstLine[2]);

        nodes = new List[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            String[] nodeNumbers = br.readLine().split(" ");
            int firstNode = Integer.parseInt(nodeNumbers[0]);
            int secondNode = Integer.parseInt(nodeNumbers[1]);

            nodes[firstNode].add(secondNode);
            nodes[secondNode].add(firstNode);
        }

        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);
    }

    private static void dfs(int here) {
        sb.append(here + " ");
        visited[here] = true;
        Collections.sort(nodes[here]);
        for (int there : nodes[here]) {
            if (!visited[there]) {
                dfs(there);
            }
        }
    }

    private static void bfs(int here) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(here);
        visited[here] = true;

        while (!queue.isEmpty()) {
            int next = queue.poll();
            Collections.sort(nodes[next]);
            sb.append(next + " ");

            for (int there : nodes[next]) {
                if (visited[there]) continue;
                queue.add(there);
                visited[there] = true;
            }
        }
    }
}
