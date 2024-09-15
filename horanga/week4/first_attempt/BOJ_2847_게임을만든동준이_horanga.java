package horanga.week4.first_attempt;

import java.util.Scanner;
public class BOJ_2847_게임을만든동준이_horanga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if(n==1){
            System.out.println(0);
            return;
        }

        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        int count=0;
        for(int i =n-1; i>0; i--){
            while(arr[i]<=arr[i-1]){
                count++;
                arr[i-1] = arr[i-1] -1;
            }

        }

        System.out.println(count);
    }
}
