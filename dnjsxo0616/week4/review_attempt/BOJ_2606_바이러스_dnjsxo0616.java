package dnjsxo0616.week4.review_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스_dnjsxo0616 {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int comNum, t, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        comNum = Integer.parseInt(br.readLine());
        t = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i=0; i<=comNum; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[comNum+1];

        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph.get(n).add(m);
            graph.get(m).add(n);
        }

        count = -1;
        DFS(1);
        System.out.println(count);
    }

    public static void DFS(int v) {
        visited[v] = true;
        count++;
        for (int node : graph.get(v)) {
            if(!visited[node]) {
                DFS(node);
            }
        }
    }
}
