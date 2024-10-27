package horanga.weeks11.first_attempt;

import java.util.*;

public class PG_전화번호목록_horanga {
        public boolean solution(String[] phone_book) {

            Arrays.sort(phone_book, (o1, o2)->{
                return o1.length()-o2.length();
            });

            Set<String> set = new HashSet<>();

            for(int i =0; i<phone_book.length; i++){
                set.add(phone_book[i]);
            }

            for(int i =0; i<phone_book.length; i++){
                String str = phone_book[i];
                StringBuilder sb = new StringBuilder();
                for(int j =0; j<str.length()-1; j++){
                    sb.append(str.charAt(j));
                    if(set.contains(sb.toString())){
                        System.out.println(sb.toString());
                        return false;
                    }
                }

            }



            return true;


        }
    }
