package dnjsxo0616.week10.review_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_수찾기_dnjsxo0616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int[] nums = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<n; j++) {
            int findNum = Integer.parseInt(st.nextToken());
            int ans = binarySearch(nums, findNum);
            System.out.println(ans);
        }

    }

    public static int binarySearch(int[] array, int findNum) {
        int low = 0;
        int high = array.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            int guess = array[mid];
            if(guess == findNum) {
                return 1;
            }
            if(guess > findNum) {
                high = mid - 1;
            } else {
                low = mid + 1 ;
            }
        }
        return 0;
    }
}
