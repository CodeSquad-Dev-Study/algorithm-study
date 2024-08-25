package dnjsxo0616.week1.review_attempt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ_1026_보물_dnjsxo0616 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();


        List<Integer> a = new ArrayList<>();
        for(int i=0; i<t; i++) {
            a.add(sc.nextInt());
        }

        List<Integer> b = new ArrayList<>();
        for(int i=0; i<t; i++) {
            b.add(sc.nextInt());
        }

        List<Integer> reverseB = new ArrayList<>(b);

        a.sort(Comparator.naturalOrder());
        reverseB.sort(Comparator.reverseOrder());

        List<Integer> indexB = new ArrayList<>();

        for(int c : reverseB) {
            indexB.add(b.indexOf(c));
        }

        int ans = 0;

        for(int j=0; j<t; j++) {
            ans += (a.get(j) * b.get(indexB.get(j)));
        }

        System.out.print(ans);
    }
}
