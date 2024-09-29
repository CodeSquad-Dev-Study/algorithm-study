package horanga.weeks7.first_attempt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PG_실패율_horanga {

        public int[] solution(int N, int[] stages) {

            int[] arr = new int[N+2];

            for(int i =0; i<stages.length; i++){
                int index = stages[i];
                arr[index]++;
            }


            List<Rate> rate = new ArrayList<>();

            for(int i =1; i<arr.length; i++){
                if(i==arr.length-1){
                    continue;
                }

                int fail =0;
                int sum =0;
                for(int j =arr.length-1; j>=i; j--){

                    sum += arr[j];
                    if(i==j){
                        fail = arr[j];
                    }
                }

                if(fail == 0){
                    rate.add(new Rate(i, 0));
                } else{

                    double r = (double) fail / (double) sum;
                    rate.add(new Rate(i, r));
                }
            }

            Collections.sort(rate);


            return rate.stream().mapToInt(i->i.getIndex()).toArray();
        }

        static class Rate implements Comparable<Rate> {
            int index;
            double rate;

            public Rate(int index, double rate) {
                this.index = index;
                this.rate = rate;
            }


            @Override
            public int compareTo(Rate o) {

                if(Double.compare(o.rate, this.rate) ==0){
                    return this.index-o.index;
                }

                return Double.compare(o.rate, this.rate);
            }

            public int getIndex(){
                return this.index;
            }
        }
}
