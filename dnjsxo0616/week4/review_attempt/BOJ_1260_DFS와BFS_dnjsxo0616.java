package dnjsxo0616.week4.review_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260_DFS와BFS_dnjsxo0616 {
    static List<Integer>[] graph;
    static List<Integer> resBFS;
    static List<Integer> resDFS;
    static boolean[] visited;
    static int n, m, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        resBFS = new ArrayList<>();
        resDFS = new ArrayList<>();
        visited = new boolean[n + 1];
        DFS(v);
        for(int k : resDFS) {
            System.out.print(k + " ");
        }
        System.out.println();
        visited = new boolean[n + 1];
        BFS(v);
        for(int k : resBFS) {
            System.out.print(k + " ");
        }
    }

    public static void BFS(int vNum){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vNum);
        visited[vNum] = true;
        resBFS.add(vNum);
        while(!queue.isEmpty()) {
            int p = queue.poll();
            for(int c : graph[p]) {
                if(!visited[c]) {
                    queue.offer(c);
                    visited[c] = true;
                    resBFS.add(c);
                }
            }

        }

    }
    public static void DFS(int v){
        visited[v] = true;
        resDFS.add(v);
        for(int c : graph[v]) {
            if(!visited[c]) {
                DFS(c);
            }
        }
    }
}
