package horanga.weeks10;

import java.util.*;

public class PG_K번째수_horanga {

    public int[] solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList();

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;

            int length = end - start + 1;
            Integer[] arr = new Integer[length];

            for (int j = start; j <= end; j++) {
                arr[j - start] = array[j];

            }

            Arrays.sort(arr);

            int k = commands[i][2] - 1;
            list.add(arr[k]);
        }


        return list.stream().mapToInt(i -> i).toArray();

    }
}
