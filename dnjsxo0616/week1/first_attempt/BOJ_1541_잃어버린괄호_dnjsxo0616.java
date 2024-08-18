package dnjsxo0616.week1.first_attempt;

import java.util.Scanner;

public class BOJ_1541_잃어버린괄호_dnjsxo0616 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String[] minusSplit = line.split("-");
        String[] pulseSplit1 = minusSplit[0].split("\\+");

        int res = 0;
        for(String n : pulseSplit1) {
            res += Integer.parseInt(n);
        }

        for(int i=1; i<minusSplit.length; i++) {
            int sum = 0;
            String[] pulseSplit2 = minusSplit[i].split("\\+");
            for(String n : pulseSplit2) {
                sum += Integer.parseInt(n);
            }
            res -= sum;
        }

        System.out.print(res);
    }
}
