package week13.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1920_수_찾기_seondays {

    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(list);

        for(int i = 0; i < m; i++) {
            System.out.println(bSearch(target[i]));
        }
    }

    public static int bSearch(int target) {
        int ro = -1;
        int hi = list.length;

        while (ro + 1 < hi) {
            int mid = (ro + hi) / 2;

            // 만일 타겟 값이 mid값보다 작으면 hi를 mid로 해야한다.
            if(target < list[mid]) {
                hi = mid;
            } else {
                ro = mid;
            }
        }
        if (ro > -1 && list[ro] == target) {
            return 1;
        }

        return 0;
    }
}
