package dnjsxo0616.week2.first_attempt;

import java.util.*;

public class BOJ_2606_바이러스_dnjsxo0616 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int turn = sc.nextInt();

        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int j=0; j<turn; j++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited.add(1);

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int num : graph[current]) {
                if (!visited.contains(num)) {
                    visited.add(num);
                    queue.add(num);
                }
            }
        }
        System.out.println(visited.size() - 1);
    }
}
