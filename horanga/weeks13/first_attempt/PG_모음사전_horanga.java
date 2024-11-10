package horanga.weeks13.first_attempt;

import java.util.*;
public class PG_모음사전_horanga {

    static List<String> list;
    static String[] arr = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();

        dfs("", 0);

        for(int i =0; i<list.size(); i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        return answer;
    }


    public static void dfs(String word, int len){
        list.add(word);
        if(len==5){
            return;
        }

        for(int i =0; i<5; i++){
            dfs(word+arr[i], len+1);
        }

    }
}
