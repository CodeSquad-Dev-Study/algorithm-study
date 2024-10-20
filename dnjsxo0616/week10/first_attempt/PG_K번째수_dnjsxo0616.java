package dnjsxo0616.week10.first_attempt;

import java.util.Arrays;

public class PG_K번째수_dnjsxo0616 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int res = findNumber(array, commands[i]);
            answer[i] = res;
        }
        return answer;
    }

    public int findNumber(int[] array, int[] command) {
        int i = command[0] - 1;
        int j = command[1];
        int k = command[2] - 1;
        int[] sub_array = Arrays.copyOfRange(array, i, j);
        Arrays.sort(sub_array);
        return sub_array[k];
    }
}
