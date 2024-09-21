package week6.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스_문제_seondays {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());

        List<Integer> linkedList = new LinkedList<>();

        for(int i = 1; i <= count; i++) {
            linkedList.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;
        while (!linkedList.isEmpty()) {
            // 제거할 인덱스 계산 (order - 1번째)
            index = (index + order - 1) % linkedList.size();
            sb.append(linkedList.remove(index));

            if (!linkedList.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}
