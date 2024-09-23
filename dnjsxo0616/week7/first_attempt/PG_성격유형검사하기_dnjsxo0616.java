package dnjsxo0616.week7.first_attempt;

import java.util.HashMap;
import java.util.Map;

public class PG_성격유형검사하기_dnjsxo0616 {
    class Solution {
        public String solution(String[] survey, int[] choices) {
            int[] score1 = {3, 2, 1};
            int[] score2 = {1, 2, 3};

            Map<Character, Integer> map = new HashMap<>(Map.of(
                    'R', 0,
                    'T', 0,
                    'C', 0,
                    'F', 0,
                    'J', 0,
                    'M', 0,
                    'A', 0,
                    'N', 0
            ));

            for(int i=0; i<survey.length; i++) {
                String s = survey[i];

                int choice = choices[i];
                if(0 < choice && choice <= 3) {
                    int plus = score1[choice - 1];
                    char t = s.charAt(0);
                    map.put(t, map.get(t)+plus);
                } else if(4 < choice && choice <= 7) {
                    int plus = score2[choice-5];
                    char t = s.charAt(1);
                    map.put(t, map.get(t)+plus);
                }
            }
            StringBuilder answer = new StringBuilder();

            answer.append(map.get('R') > map.get('T') ? 'R' : (map.get('R').equals(map.get('T')) ? 'R' : 'T'));
            answer.append(map.get('C') > map.get('F') ? 'C' : (map.get('C').equals(map.get('F')) ? 'C' : 'F'));
            answer.append(map.get('J') > map.get('M') ? 'J' : (map.get('J').equals(map.get('M')) ? 'J' : 'M'));
            answer.append(map.get('A') > map.get('N') ? 'A' : (map.get('A').equals(map.get('N')) ? 'A' : 'N'));


            return answer.toString();
        }
    }
}
