package horanga.week4.review_attempt;

import java.util.Scanner;
import java.util.Arrays;

public class BOJ_1026_보물_horanga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Integer[] arr = new Integer[n];
        Integer[] arr2 = new Integer[n];

        for(int i =0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        for(int i =0; i<n; i++){
            arr2[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        Arrays.sort(arr2, (o1, o2) -> o2 - o1);

       int sum =0;

       for(int i =0; i<n; i++){
           sum +=arr[i]*arr2[i];
       }

       System.out.println(sum);

    }
}
