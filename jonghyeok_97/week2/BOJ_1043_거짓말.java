package jonghyeok_97.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BOJ_1043_거짓말 {

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
        List<Integer> secondeLine = Stream.of(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (0 == secondeLine.get(0)) {
            System.out.println(M);
            return;
        }
        secondeLine.remove(0);

        List<Integer>[] parties = new ArrayList[M+1];

        for (int i = 1; i <= M; i++) {
            List<Integer> participants = Stream.of(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            participants.remove(0);
            parties[i] = participants;

            int size = participants.size();
            for (int j = 0; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    people[participants.get(j)].add(participants.get(k));
                    people[participants.get(k)].add(participants.get(j));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < secondeLine.size(); i++) {
            dfs(secondeLine.get(i));
        }

        for (int i = 1; i <= M; i++) {
            boolean b = parties[i].stream()
                    .anyMatch(num -> visited[num]);
            if (!b) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int here) {
        visited[here] = true;

        for (int there : people[here]) {
            if(visited[there]) continue;
            dfs(there);
        }
    }
}
