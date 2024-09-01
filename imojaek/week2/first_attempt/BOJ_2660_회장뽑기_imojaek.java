package imojaek.week2.first_attempt;

import java.util.*;

public class BOJ_2660_회장뽑기_imojaek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        while (p1 != -1 && p2 != -1){
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
            p1 = sc.nextInt();
            p2 = sc.nextInt();
        }

        int[] scores = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            scores[i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            boolean[] isVisited = new boolean[n + 1];
            scores[i] = bfs(i, graph, isVisited);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < scores.length; i++) {
            if (min > scores[i])
                min = scores[i];
        }

        List<Integer> gnqh = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (scores[i] == min)
                gnqh.add(i);
        }

        System.out.println(min + " " + gnqh.size());
        for (int i = 0; i < gnqh.size(); i++) {
            if (i == gnqh.size() - 1)
                System.out.print(gnqh.get(i));
            else
                System.out.print(gnqh.get(i) + " ");
        }

    }

    public static int bfs(int member, List<List<Integer>> graph, boolean[] isVisited) {
        Queue<Integer> queue = new LinkedList<>();
        isVisited[member] = true;
        queue.add(member);

        int[] bridge = new int[graph.size() + 1];
        Arrays.fill(bridge, Integer.MAX_VALUE);

        bridge[member] = 0;
        int score = 0;

        while (!queue.isEmpty()) {
            int currentFriend = queue.poll();

            for (int friend : graph.get(currentFriend)) {
                if (!isVisited[friend]) {
                    isVisited[friend] = true;
                    int tmp = bridge[currentFriend] + 1;
                    bridge[friend] = tmp;
                    if (score < tmp)
                        score = tmp;
                    queue.add(friend);
                }
            }
        }

         return score;
    }
}
