package yonghyeonpark.week16.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_19583_싸이버개강총회_yonghyeonpark {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = toInt(st.nextToken());
        int e = toInt(st.nextToken());
        int q = toInt(st.nextToken());

        Map<String, Integer> count = new HashMap<>();
        int result = 0;
        String input;
        while ((input = br.readLine()) != null && !input.trim().isEmpty()) {
            st = new StringTokenizer(input);

            int time = toInt(st.nextToken());
            String name = st.nextToken();

            int cur = count.getOrDefault(name, 0);
            if (cur == 0 && time <= s) {
                count.put(name, 1);
            }
            if (cur == 1 && (time >= e && time <= q)) {
                count.put(name, 2);
                result++;
            }
        }
        System.out.println(result);
    }

    private static int toInt(String time) {
        return Integer.parseInt(time.replace(":", ""));
    }
}
