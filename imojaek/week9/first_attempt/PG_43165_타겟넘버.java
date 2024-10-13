package imojaek.week9.first_attempt;

import java.util.Stack;

public class PG_43165_타겟넘버 {
    int answer = 0;
    int[] numberGlobal;
    int targetGlobal;
    public int solution(int[] numbers, int target) {
        numberGlobal = numbers;
        targetGlobal = target;

        dfs();

        return answer;
    }


    public void dfs() {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {0, 0});

        int POS_INDEX = 0;
        int SUM_INDEX = 1;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int pos = current[POS_INDEX];
            int sum = current[SUM_INDEX];

            if (pos == numberGlobal.length) {
                if (sum == targetGlobal) {
                    answer++;
                }
                continue ;
            }

            stack.push(new int[] {pos + 1, sum + numberGlobal[pos]});
            stack.push(new int[] {pos + 1, sum - numberGlobal[pos]});
        }

        return ;
    }

}
