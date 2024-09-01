package dnjsxo0616.week3.first_attempt;

import java.util.*;

public class BOJ_2583_영역구하기_dnjsxo0616 {
    static int m, n, k;
    static int[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static List<Integer> res;

    static class Node{
        int x;
        int y;

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        graph = new int[m][n];
        visited = new boolean[m][n];
        res = new ArrayList<>();

        for(int i=0; i<k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int y=y1; y<y2; y++) {
                for(int x=x1; x<x2; x++) {
                    graph[y][x] = 1;
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(graph[i][j] == 0 && !visited[i][j]) {
                    int s = BFS(i, j);
                    res.add(s);
                }
            }
        }

        Collections.sort(res);
        System.out.println(res.size());
        for(int n : res) {
            System.out.print(n + " ");
        }
    }
    public static int BFS(int row, int col) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col));
        visited[row][col] = true;
        int count = 1;

        while(!queue.isEmpty()) {
            Node p = queue.poll();
            for(int i=0; i<4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if(nextX >= 0 && nextY >=0 && nextX < n && nextY < m && !visited[nextY][nextX] && graph[nextY][nextX] == 0) {
                    visited[nextY][nextX] = true;
                    queue.add(new Node(nextY, nextX));
                    count++;
                }
            }
        }
        return count;
    }
}
