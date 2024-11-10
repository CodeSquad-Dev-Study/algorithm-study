package horanga.weeks13.first_attempt;

import java.util.*;
public class PG_연속부분수열합의개수_horanga {

    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();

        for(int i =0; i<elements.length; i++){
            int length = i;


            for(int j=0; j<elements.length; j++){
                int num=0;
                for(int k = j; k<j+i; k++){
                    num +=elements[k%elements.length];
                }
                set.add(num);
            }

        }

        return set.size();
    }
}
