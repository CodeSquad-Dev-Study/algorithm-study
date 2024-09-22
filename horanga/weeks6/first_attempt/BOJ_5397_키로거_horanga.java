package horanga.weeks6.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5397_키로거_horanga {

    static ListIterator iterator;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(bufferedReader.readLine());
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String line = bufferedReader.readLine();
            Queue<String> link = new LinkedList<>();
            iterator = (ListIterator) link.iterator();

            for (int j = 0; j < line.length(); j++) {
                String ch = line.charAt(j) + "";

                if (ch.equals("<")) {
                    left();
                } else if (ch.equals(">")) {
                    right();
                } else if (ch.equals("-")) {
                    backSpace();
                } else {
                    iterator.add(ch);
                }
            }

                StringBuilder stringBuilder = new StringBuilder();

            while(!link.isEmpty()){
                    stringBuilder.append(link.poll());
                }

                answer.add(stringBuilder.toString());

        }

        answer.forEach(System.out::println);
    }

    private static void left() {
        if (iterator.hasPrevious()) {
            iterator.previous();
        }

    }

    private static void right() {
        if (iterator.hasNext()) {
            iterator.next();
        }
    }

    private static void backSpace(){
        if(iterator.hasPrevious()){
            iterator.previous();
            iterator.remove();
        }
    }

}
