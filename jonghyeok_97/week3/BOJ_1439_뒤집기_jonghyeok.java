package jonghyeok_97.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439_뒤집기_jonghyeok {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        char c = s.charAt(0);
        int one = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == c && s.charAt(i + 1) != c) {
                one++;
            }
        }
        System.out.println(one);
    }
}
