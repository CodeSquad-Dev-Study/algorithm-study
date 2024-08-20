package horanga.week1.review_attempt;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1026_보물_horanga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int[] first = new int[num];
        Integer[] second = new Integer[num];

        for(int i =0; i<num; i++){
            first[i] = scanner.nextInt();
            second[i]= scanner.nextInt();
        }

        Arrays.sort(first);
        Arrays.sort(second, Comparator.reverseOrder());

        int sum=0;
        for(int i =0; i<num; i++){
            sum +=first[i]*second[i];
        }

        System.out.println(sum);
    }
}
