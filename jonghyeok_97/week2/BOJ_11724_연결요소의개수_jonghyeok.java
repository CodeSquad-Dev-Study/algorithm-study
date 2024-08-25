package jonghyeok_97.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_11724_연결요소의개수_jonghyeok {

    private static List<Integer>[] nodes;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        nodes = new List[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] lines = br.readLine().split(" ");
            int node1 = Integer.parseInt(lines[0]);
            int node2 = Integer.parseInt(lines[1]);

            nodes[node1].add(node2);
            nodes[node2].add(node1);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void bfs(int here) {
        Queue<Integer> q = new LinkedList<>();
        q.add(here);
        visited[here] = true;
        while (!q.isEmpty()) {
            int next = q.poll();

            for (int there : nodes[next]) {
                if(visited[there]) continue;
                q.add(there);
                visited[there] = true;
            }
        }
    }
}
