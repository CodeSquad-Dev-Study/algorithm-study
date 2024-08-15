package horanga.week1.first_attempt;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399_ATM_horagna {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] array = new int[n];

        for(int i =0; i<n; i++){
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);
        int sum=array[0];
        int plus = array[0];
        for(int i=1; i<n; i++){
            plus += array[i];
            sum += plus;
        }

        System.out.println(sum);

    }
}
