package dnjsxo0616.week5.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스문제_dnjsxo0616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        LinkedList<Integer> nums = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            nums.add(i);
        }

        int index = 0;
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; i++) {
            index = (index + (k - 1)) % nums.size();
            System.out.println(index);
            int r = nums.remove(index);
            res.add(r);
        }


        System.out.print("<");
        for(int i=0; i<res.size(); i++) {
            System.out.print(res.get(i));
            if(i<res.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(">");
    }
}
