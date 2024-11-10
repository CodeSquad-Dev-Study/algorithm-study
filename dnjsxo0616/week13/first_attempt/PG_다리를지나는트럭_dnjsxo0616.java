package dnjsxo0616.week13.first_attempt;

import java.util.LinkedList;
import java.util.Queue;

public class PG_다리를지나는트럭_dnjsxo0616 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < bridge_length - 1; i++) {
            q.offer(0);
        }

        int currentW = truck_weights[0];
        q.add(currentW);

        int index = 1;
        int answer = 1;
        while (!q.isEmpty()) {
            answer++;

            int bridgeTruck = q.poll();
            currentW -= bridgeTruck;

            if (index < truck_weights.length) {
                if (currentW + truck_weights[index] <= weight) {
                    currentW += truck_weights[index];
                    q.add(truck_weights[index]);
                    index++;
                } else {
                    q.offer(0);
                }
            }
        }
        return answer;
    }
}
