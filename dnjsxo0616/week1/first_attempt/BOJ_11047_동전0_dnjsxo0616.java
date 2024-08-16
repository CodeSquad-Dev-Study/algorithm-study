package dnjsxo0616.week1.first_attempt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_11047_동전0_dnjsxo0616 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        int money = sc.nextInt();
        List<Integer> unit = new ArrayList<>();

        for(int i=0; i<line; i++) {
            unit.add(sc.nextInt());
        }
        int count = 0;

        while(money > 0) {
            for(int j=unit.size()-1; j>=0; j--) {
                count += money / unit.get(j);
                money %= unit.get(j);
            }
        }

        System.out.print(count);
    }
}
