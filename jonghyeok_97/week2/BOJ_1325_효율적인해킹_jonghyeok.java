package jonghyeok_97.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class BOJ_1325_효율적인해킹_jonghyeok {

    private static boolean[] visited;
    private static List<Integer>[] computers;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        visited = new boolean[N];
        computers = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] numbers = br.readLine().split(" ");
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);

            computers[b-1].add(a-1);
        }

        int[] result = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            int ret = dfs(i);
            result[i] = ret;
            max = Math.max(ret, max);
        }

        StringJoiner joiner = new StringJoiner(" ");
        for (int i = 0; i < result.length; i++) {
            if (result[i] == max) {
                joiner.add((i+1)+"");
            }
        }
        System.out.println(joiner);
    }

    private static int dfs(int here) {
        int count = 1;
        visited[here] = true;
        for (int there : computers[here]) {
            if(visited[there]) continue;
            count += dfs(there);
        }
        return count;
    }
}
