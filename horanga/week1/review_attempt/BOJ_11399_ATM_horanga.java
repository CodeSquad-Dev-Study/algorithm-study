package horanga.week1.review_attempt;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399_ATM_horanga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] array = new int[n];
        for(int i =0; i<n; i++){
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);
        int sum=0;
        int sum2=0;

        for(int i =0; i<n; i++){
            sum2 +=array[i];
            sum+= sum2;
        }

        System.out.println(sum);
    }
}
