package horanga.weeks9.first_attempt;

import java.util.HashMap;
import java.util.Map;

public class PG_숫자문자열과영단어_horanga {

    public int solution(String s) {
        Map<String, Integer> words = new HashMap<>();

        words.put("zero", 0);
        words.put("one", 1);
        words.put("two", 2);
        words.put("three", 3);
        words.put("four", 4);
        words.put("five", 5);
        words.put("six", 6);
        words.put("seven", 7);
        words.put("eight", 8);
        words.put("nine", 9);

        char[] sa = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        sb.isEmpty();

        for(int i =0; i<sa.length; i++){
            if(sa[i]-64<10){
                sb2.append(sa[i]);
            } else{
                sb.append(sa[i]);
            }

            if(words.containsKey(sb.toString())){
                Integer in = words.get(sb.toString());
                sb2.append(in);
                sb = new StringBuilder();
            }
        }

        return Integer.valueOf(sb2.toString());
    }
}
