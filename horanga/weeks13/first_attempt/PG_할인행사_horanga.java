package horanga.weeks13.first_attempt;

import java.util.*;
public class PG_할인행사_horanga {

    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();

        for(int i =0; i<want.length; i++){
            map.put(want[i], number[i]);
        }

        int consecutiveDays = 10;

        int count=0;
        for(int i =0; i<discount.length-9; i++){

            Map<String, Integer> dMap = new HashMap<>();

            for(int j =0; j<=9; j++){
                dMap.put(discount[i+j], dMap.getOrDefault(discount[i+j], 0)+1);
            }

            boolean isIdentical = true;
            for(String key : map.keySet()){
                if(map.get(key) != dMap.get(key)){
                    isIdentical = false;
                    break;
                }
            }

            if(isIdentical){
                count++;
            }
        }

        return count;

    }
}
