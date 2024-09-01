package jonghyeok_97.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class BOJ_1766_문제집_jonghyeok {

    private static int N;
    private static int M;
    private static List<Integer>[] nodes;
    private static int[] count;
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        N = inputs[0];
        M = inputs[1];
        nodes = new ArrayList[N + 1];
        count = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        List<Integer> adds = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int[] inputs2 = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int A = inputs2[0];
            int B = inputs2[1];

            nodes[A].add(B);
            count[B]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int there = pq.poll();
            result.add(there);
            for (int next : nodes[there]) {
                count[next]--;
                if (count[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
