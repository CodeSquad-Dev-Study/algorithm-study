package dnjsxo0616.week3.first_attempt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2468_안전영역_dnjsxo0616 {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int t, res;
    static class Node {
        int x;
        int y;

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        graph = new int[t][t];

        int max = 0;
        for(int i=0; i<t; i++) {
            for(int j=0; j<t; j++) {
                graph[i][j] = sc.nextInt();
                max = Math.max(max, graph[i][j]);
            }
        }

        for(int h=0; h<max; h++) {
            visited = new boolean[t][t];
            int count = 0;
            for(int i=0; i<t; i++) {
                for(int j=0; j<t; j++){
                    if(!visited[i][j] && graph[i][j] > h) {
                        BFS(i, j, h);
                        count ++;
                    }
                }
                res = Math.max(count, res);
            }
        }
        System.out.print(res);
    }
    public static void BFS(int row, int col, int h) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int i=0; i<4; i++) {
                int nextY = node.y + dy[i];
                int nextX = node.x + dx[i];

                if(nextY < 0 || nextX < 0 || nextY >= t || nextX >= t) {
                    continue;
                }
                if(visited[nextY][nextX] || graph[nextY][nextX] <= h) {
                    continue;
                }
                visited[nextY][nextX] = true;
                queue.add(new Node(nextY, nextX));
            }
        }
    }
}
