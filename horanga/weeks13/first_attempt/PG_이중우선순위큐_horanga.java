package horanga.weeks13.first_attempt;

import java.util.*;

public class PG_이중우선순위큐_horanga {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2)-> o2-o1);
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for(int i =0; i<operations.length; i++){
            String[] splits = operations[i].split(" ");

            if(splits[0].equals("I")){
                max.add(Integer.parseInt(splits[1]));
                min.add(Integer.parseInt(splits[1]));
            }

            if(splits[0].equals("D")){
                if(splits[1].equals("1")){
                    min.remove(max.poll());
                } else {
                    max.remove(min.poll());
                }
            }
        }

        int mi = min.isEmpty()? 0: min.poll();
        int ma = max.isEmpty()? 0: max.poll();

        return new int[]{ma, mi};

    }

}
