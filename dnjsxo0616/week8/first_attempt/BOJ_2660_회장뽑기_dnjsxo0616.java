package dnjsxo0616.week8.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2660_회장뽑기_dnjsxo0616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new ArrayList[n+1];

        for(int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1) {
                break;
            }
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] score = new int[n+1];

        for(int i=1; i<=n; i++) {
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;
            int distance = 0;

            while(!queue.isEmpty()) {
                int size = queue.size();
                for(int j=0; j<size; j++) {
                    int c = queue.poll();
                    for(int neighbor : graph[c]) {
                        if(!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.add(neighbor);
                        }
                    }
                }
                distance++;
            }
            score[i] = distance - 1;
        }

        int mixScore = Integer.MAX_VALUE;
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            if(score[i] < mixScore) {
                mixScore = score[i];
                numbers.clear();
                numbers.add(i);
                continue;
            }
            if(score[i] == mixScore) {
                numbers.add(i);
            }
        }

        Collections.sort(numbers);
        System.out.println(mixScore + " " + numbers.size());
        for(int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
