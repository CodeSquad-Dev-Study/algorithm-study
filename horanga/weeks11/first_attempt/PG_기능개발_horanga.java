package horanga.weeks11.first_attempt;

import java.util.*;
public class PG_기능개발_horanga {

    public int[] solution(int[] progresses, int[] speeds) {



        Queue<Job> queue = new LinkedList<>();


        for(int i =0; i<progresses.length; i++){
            Job job = new Job(progresses[i], speeds[i]);
            queue.add(job);
        }

        List<Integer> list = new ArrayList<>();
        int count=0;

        while(!queue.isEmpty()){
            int answer =1;
            Job job = queue.poll();
            count += job.getCount(count);
            System.out.println(count);
            while(!queue.isEmpty() && queue.peek().isOver(count)){
                Job j = queue.poll();
                answer++;
            }
            list.add(answer);

        }

        return list.stream().mapToInt(i->i).toArray();
    }



    public class Job{
        int progress;
        int speeds;

        public Job(int progress, int speeds){
            this.progress = progress;
            this.speeds = speeds;

        }

        public int getProgress(){
            return progress;
        }

        public int getSpeeds(){
            return speeds;
        }

        public int getCount(int count){
            progress += speeds*count;
            int c =0;
            while(progress < 100){
                progress += speeds;
                c++;
            }

            return c;
        }

        public boolean isOver(int count){
            return progress+(speeds*count)>=100;
        }


    }
}
