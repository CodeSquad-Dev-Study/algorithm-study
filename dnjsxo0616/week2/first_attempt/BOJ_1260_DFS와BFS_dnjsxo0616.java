package dnjsxo0616.week2.first_attempt;

import java.util.*;

public class BOJ_1260_DFS와BFS_dnjsxo0616 {
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static List<Integer> resDFS;
    static List<Integer> resBFS;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정점의 개수
        int m = sc.nextInt(); // 간선의 개수
        int v = sc.nextInt(); // 탐색을 시작할 정점의 번호

        graph = new LinkedList[n + 1];
        resDFS = new ArrayList<>();
        resBFS = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            graph[i] = new LinkedList<>();
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        // DFS
        visited = new boolean[n + 1];
        DFS(v);
        // 마지막 숫자에는 공백이 들어가지 않도록 출력
        for (int i = 0; i < resDFS.size(); i++) {
            System.out.print(resDFS.get(i));
            if (i < resDFS.size() - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        // BFS
        visited = new boolean[n + 1];
        BFS(v);
        for (int i = 0; i < resBFS.size(); i++) {
            System.out.print(resBFS.get(i));
            if (i < resBFS.size() - 1) {
                System.out.print(" ");
            }
        }

    }
    public static void DFS(int vNum) {
        visited[vNum] = true;
        resDFS.add(vNum);

        for(int nNum : graph[vNum]) {
            if(!visited[nNum]) {
                if(!visited[nNum]) {
                    DFS(nNum);
                }
            }
        }
    }

    public static void BFS(int vNUm) {
        // BFS를 위한 큐 생성
        LinkedList<Integer> queue = new LinkedList<>();

        visited[vNUm] = true;
        queue.add(vNUm);

        while(!queue.isEmpty()) {
            int q = queue.poll();
            resBFS.add(q);

            for(int nNum: graph[q]) {
                if(!visited[nNum]) {
                    visited[nNum] = true;
                    queue.add(nNum);
                }
            }
        }
    }
}
