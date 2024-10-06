package dnjsxo0616.week8.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2_dnjsxo0616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<m; j++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(upperBound(nums, num) - lowerBound(nums, num)).append(" ");
        }
        System.out.println(sb);
    }
    public static int lowerBound(int[] nums, int key) {
        int lo = 0;
        int hi = nums.length;

        while(lo < hi) {
            int mid = (lo + hi) / 2;

            if (key <= nums[mid]) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }
        return lo;
    }

    public static int upperBound(int[] nums, int key) {
        int lo = 0;
        int hi = nums.length;

        while(lo < hi) {
            int mid = (lo + hi) / 2;

            if (key < nums[mid]) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
