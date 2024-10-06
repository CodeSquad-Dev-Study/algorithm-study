package imojaek.week8.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BOJ_18870_좌표압축_imojaek {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortedArr = new int[N];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            sortedArr[i] = arr[i];
        }

        Arrays.sort(sortedArr);

        Map<Integer, Integer> map = new HashMap<>();
        int currentCount = 0;

        for (int value : sortedArr) {
            if (!map.containsKey(value)) {
                map.put(value, currentCount++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int value : arr) {
            sb.append(map.get(value)).append(" ");
        }

        System.out.println(sb);
    }
}

