package dnjsxo0616.week9.first_attempt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG_신규아이디추천_dnjsxo0616 {
    class Solution {
        static List<Character> alphabet = new ArrayList<>(Arrays.asList('-', '_', '.'));

        public String solution(String new_id) {
            new_id = new_id.toLowerCase();
            StringBuilder checkId1 = new StringBuilder();
            for (int i = 0; i < new_id.length(); i++) {
                char currentChar = new_id.charAt(i);
                if (Character.isLowerCase(currentChar) || Character.isDigit(currentChar) || alphabet.contains(currentChar)) {
                    checkId1.append(currentChar);
                    continue;
                }

            }

            StringBuilder checkId2 = new StringBuilder();
            boolean check = false;
            for (int i = 0; i < checkId1.length(); i++) {
                char c = checkId1.charAt(i);
                if (c == '.') {
                    if (!check) {
                        checkId2.append(c);
                        check = true;
                    }
                } else {
                    checkId2.append(c);
                    check = false;
                }
            }


            if (checkId2.length() > 0 && checkId2.charAt(0) == '.') {
                checkId2.deleteCharAt(0);
            }
            if (checkId2.length() > 0 && checkId2.charAt(checkId2.length() - 1) == '.') {
                checkId2.deleteCharAt(checkId2.length() - 1);
            }

            if (checkId2.length() == 0) {
                checkId2.append('a');
            }

            if (checkId2.length() >= 16) {
                checkId2.setLength(15);
                if (checkId2.length() > 0 && checkId2.charAt(checkId2.length() - 1) == '.') {
                    checkId2.deleteCharAt(checkId2.length() - 1);
                }
            }

            if (checkId2.length() <= 2) {
                char c = checkId2.charAt(checkId2.length() - 1);
                while (checkId2.length() < 3) {
                    checkId2.append(c);
                }
            }

            return checkId2.toString();
        }
    }
}
