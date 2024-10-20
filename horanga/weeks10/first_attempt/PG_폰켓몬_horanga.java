package horanga.weeks10.first_attempt;

import java.util.*;
public class PG_폰켓몬_horanga {


    public int solution(int[] nums) {
   Set<Integer> set = new HashSet<>();


        for(int i =0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int max =0;

        if(nums.length%2==0){
            max = nums.length/2;

        } else{
            max = (nums.length+1)/2;
        }

        return set.size()<max? set.size(): max;

    }
}
