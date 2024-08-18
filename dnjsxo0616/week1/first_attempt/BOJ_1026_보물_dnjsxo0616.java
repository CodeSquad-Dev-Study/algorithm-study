package dnjsxo0616.week1.first_attempt;

import java.util.*;

public class BOJ_1026_보물_dnjsxo0616 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        List<Integer> aNumbers = new ArrayList<>();
        List<Integer> bNumbers = new ArrayList<>();
        for(int i=0; i<r; i++) {
            aNumbers.add(sc.nextInt());
        }

        for(int i=0; i<r; i++) {
            bNumbers.add(sc.nextInt());
        }

        Collections.sort(aNumbers);
        List<Integer> bReverseSorted = new ArrayList<>(bNumbers);
        bReverseSorted.sort(Comparator.reverseOrder());
//      List<Integer> bReverseSorted = bNumbers.stream().sorted(Comparator.reverseOrder()).toList();

        List<Integer> bIndex = new ArrayList<>();
        for(int br : bReverseSorted) {
            bIndex.add(bNumbers.indexOf(br));
        }

        int res = 0;
        int b = 0;
        for(int a : aNumbers) {
            res += (a * bNumbers.get(bIndex.get(b)));
            b += 1;
        }

        System.out.println(res);

    }
}
