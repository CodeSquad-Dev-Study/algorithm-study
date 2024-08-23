package jonghyeok_97.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_1389_케빈베이컨6단계법칙_jonghyeok {

    private static boolean[] visited;
    private static List<Integer>[] people;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        visited = new boolean[N + 1];
        people = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            people[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] numbers = br.readLine().split(" ");
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);

            people[b].add(a);
            people[a].add(b);
        }

        int[] results = new int[N + 1];
        int MAX = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int result = 0;
            visited = new boolean[N+1];

            result = bfs(i);
            results[i] = result;
            MAX = Math.min(MAX, result);
        }

        for (int i = 1; i <= N; i++) {
            if (MAX == results[i]) {
                System.out.print(i);
                return;
            }
        }
    }

    private static int bfs(int here) {
        Queue<Position> q = new LinkedList<>();
        visited[here] = true;
        q.add(new Position(here, 0));
        int result = 0;
        while (!q.isEmpty()) {
            Position p = q.poll();
            for (int nextPerson : people[p.person]) {
                if(visited[nextPerson]) continue;
                visited[nextPerson] = true;
                result += p.level + 1;
                q.add(new Position(nextPerson, p.level + 1));
            }
        }
        return result;
    }

    static class Position {
        private final int person;
        private final int level;

        public Position(int person, int level) {
            this.person = person;
            this.level = level;
        }
    }
}
