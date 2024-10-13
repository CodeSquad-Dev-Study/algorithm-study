package horanga.weeks9.first_attempt;

import java.util.HashSet;
import java.util.Set;

public class PG_연속부분수열합의개수_horanga {


    public int solution(int[] elements) {

        Set<Integer> set = new HashSet<>();

        for(int i =1; i<=elements.length;i++) {
            int length = i;

            for(int j =0; j<elements.length; j++){
                int sum =0;
                for(int k =j; k<j+length; k++) {
                    int index =k;
                    if(index>=elements.length){
                        index -= elements.length;
                    }

                    sum += elements[index];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}
