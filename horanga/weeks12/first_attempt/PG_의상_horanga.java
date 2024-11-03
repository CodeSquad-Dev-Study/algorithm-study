package horanga.weeks12.first_attempt;

import java.util.*;

class PG_의상_horanga {
    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();

        for(int i =0; i<clothes.length ; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }


        int answer =1;

        for(String a : map.keySet()){
            answer *=(map.get(a)+1);
        }
        return answer-1;
    }
}