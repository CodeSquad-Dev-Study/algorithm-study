package dnjsxo0616.week1.first_attempt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2847_게임을만든동준이_dnjsxo0616 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();

        List<Integer> numbers = new ArrayList<>();
        int count = 0;

        for(int i=0; i<line; i++) {
            numbers.add(sc.nextInt());
        }

        for(int i=line-2; i>=0; i--) {
            int first = numbers.get(i);
            int second = numbers.get(i + 1);
            if(first >= second) {
                int c = (first - second) + 1;
                count += c;
                numbers.set(i, first-c);
            }
        }

        System.out.print(count);
    }
}
