package imojaek.week9.first_attempt;

import java.util.Stack;

public class PG_43162_네트워크 {
    int answer = 0;
    boolean[] visited;
    int arrSize;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        arrSize = n;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    public void bfs(int i, int[][] computers) {
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        visited[i] = true;

        while (!stack.isEmpty()) {
            int currentCom = stack.pop();

            for (int j = 0; j < arrSize; j++) {
                if (computers[currentCom][j] == 1 && !visited[j]) {
                    stack.push(j);
                    visited[j] = true;
                }
            }

        }


    }
}
