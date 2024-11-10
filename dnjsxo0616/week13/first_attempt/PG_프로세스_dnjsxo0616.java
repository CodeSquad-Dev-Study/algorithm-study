package dnjsxo0616.week13.first_attempt;

import java.util.LinkedList;
import java.util.Queue;

public class PG_프로세스_dnjsxo0616 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> q = new LinkedList<>();

        for(int i=0; i<priorities.length; i++) {
            q.add(new Process(i, priorities[i]));
        }

        int count = 0;

        while(!q.isEmpty()) {
            Process currentP = q.poll();
            boolean check = true;

            for(Process p : q) {
                if(p.priority > currentP.priority) {
                    check = false;
                    break;
                }
            }

            if(check) {
                count++;
                if(currentP.index == location) {
                    return count;
                }
            } else {
                q.add(currentP);
            }
        }

        return answer;
    }
}
class Process {
    int index;
    int priority;

    public Process(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}
