package horanga.week1.review_attempt;

import java.util.Scanner;

public class BOJ_11047_동전0_horanga {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int criteria = scanner.nextInt();

        int[] array = new int[num];
        for(int i =0; i<num; i++){
            array[i] = scanner.nextInt();
        }

        int answer =0;
        int sum =0;

        for(int i =num-1; i>=0; i--) {
            if(sum==criteria){
                break;
            }

            while (sum+array[i] <= criteria) {
                sum += array[i];
                answer++;
            }
        }

        System.out.println(answer);
    }
}
