package horanga.week1.review_attempt;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11000_강의실배정_horanga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];

        for(int i =0; i<n; i++){
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        Arrays.sort(arr, (o1, o2) -> {


            /*
            끝나는 시간 순서로 정렬하니 틀렸다. 어차피 끝나는 시간은 우선순위 큐에 걸리니 상관없는데
            시작시간으로 정렬을 해야 하는 건 왜 일까?

            1 3 // 2 5 // 7 8 // 9 10 //7 11 //4 12

            (1)끝나는 시간 정렬

            1 3 // 2 5 // 4 12 // 7 8 // 7 11 //9 10

            (2)시작하는 시간 정렬


            (1)일 때는 큐에 3과 2가 들어간다.(강의실 2 개) 그리고, 2가 빠지고 8이 들어가고 3이 빠지고 10이 들어간다. (강의실 2개)
            7, 11은 큐에 있는 끝나는 시간 8과 10보다 빠르므로 세번째 강의실에 넣어야 한다. 4,12는 큐에 있는 종료시간이 8, 10, 11보다
            빠르므로 네번째 강의실에 넣는다.

            (2)일 떄는 1-3 -> 4-12 (강의실1) 2-5 ->7-8-> 9-10(강의실 2)  // 7-11(강의실 3)

            즉, 우선순위 큐에 있는 매 만에 있는(가장 빠른 종료시간)에 들어갈 수 있는 가장 빠른 수업시간이 필요한 것이다.

             */
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }

            return o1[0] - o2[0];
        });


        Queue<Integer> end = new PriorityQueue<>();
        for(int i =0; i<n; i++){
            if(!end.isEmpty()&& end.peek()<=arr[i][0]) {
                end.poll();
            }
                     end.add(arr[i][1]);
        }

        System.out.println(end.size());

    }
}
