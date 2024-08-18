package horanga.week1.first_attempt;

import java.util.Scanner;

public class BOJ_11047_동전0_horanga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int money = scanner.nextInt();

        int[] arr = new int[a];
        for(int j =0; j<a; j++){
            arr[j] = scanner.nextInt();
        }
        int sum =0;
        int count=0;

        for(int j =a-1; j>=0; j--){

            while(sum+arr[j] <= money){
                sum += arr[j];
                count++;
            }

            if(sum==money){
                break;
            }
        }
        System.out.println(count);
    }
}
