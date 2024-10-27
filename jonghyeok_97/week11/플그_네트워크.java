package jonghyeok_97.week11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 플그_네트워크 {

    static boolean[] visited = new boolean[204];

    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<Integer>[] nodes = new List[204];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = i + 1; j < computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    nodes[i].add(j);
                    nodes[j].add(i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            bfs(i, nodes);
            answer++;
        }
        return answer;
    }

    private void bfs(int here, List<Integer>[] nodes) {
        Queue<Integer> q = new LinkedList<>();
        q.add(here);
        visited[here] = true;

        while (!q.isEmpty()) {
            int there = q.poll();
            for (int next : nodes[there]) {
                if (visited[next]) {
                    continue;
                }
                q.add(next);
                visited[next] = true;
            }
        }

    }
}
