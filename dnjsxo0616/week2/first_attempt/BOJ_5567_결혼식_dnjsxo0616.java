package dnjsxo0616.week2.first_attempt;

import java.util.*;

public class BOJ_5567_결혼식_dnjsxo0616 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 동기의 수
        int m = sc.nextInt(); // 리스트의 길이

        //상근이는 1번
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited[1] = true;
        queue.add(1);
        int level = 0;
        int count = 0;

        while(!queue.isEmpty() && level < 2) {
            int size = queue.size();
            level++;

            for(int i=0; i<size; i++) {
                if(queue.isEmpty()) {
                    System.out.print(0);
                    break;
                }
                int c = queue.poll();

                for(int f : graph.get(c)) {
                    if(!visited[f]) {
                        visited[f] = true;
                        queue.add(f);
                        count++;
                    }
                }
            }
        }

        System.out.print(count);

    }
}
