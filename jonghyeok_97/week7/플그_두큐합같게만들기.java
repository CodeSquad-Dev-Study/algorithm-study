package jonghyeok_97.week7;

import java.util.LinkedList;
import java.util.Queue;

public class 플그_두큐합같게만들기 {

    public int solution(int[] queue1, int[] queue2) {
        long sumQ1 = 0L;
        long sumQ2 = 0L;

        Queue<Integer> list1 = new LinkedList<>();
        Queue<Integer> list2 = new LinkedList<>();

        for (int q1 : queue1) {
            list1.offer(q1);
            sumQ1 += q1;
        }
        for (int q2 : queue2) {
            list2.offer(q2);
            sumQ2 += q2;
        }

        if ((sumQ1 + sumQ2) % 2 != 0) {
            return -1;
        }
        //     int len1 = (list1.size() + list2.size()) * 2;
        int len1 = list1.size() * 2;
        int len2 = list2.size() * 2;
        int count = 0;
        int move1 = 0;
        int move2 = 0;
        while (!list1.isEmpty() && !list2.isEmpty()) {
            if (sumQ1 == sumQ2) {
                break;
            }
            // if(len1 < count) {
            //     return -1;
            // }
            if (move1 > len1 && move2 > len2) {
                return -1;
            } else if (sumQ1 > sumQ2) {
                int first = list1.poll();
                list2.add(first);
                sumQ1 -= first;
                sumQ2 += first;
                move1++;
            } else {
                int first = list2.poll();
                list1.add(first);
                sumQ1 += first;
                sumQ2 -= first;
                move2++;
            }
            count++;
        }
        //    System.out.println(list1 +" : "+ list2);

        return count;
    }

}
