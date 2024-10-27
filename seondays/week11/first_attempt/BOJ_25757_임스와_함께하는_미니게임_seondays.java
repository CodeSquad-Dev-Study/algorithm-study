package week11.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_25757_임스와_함께하는_미니게임_seondays {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> player = new HashSet<>();

        Map<String, Integer> game = new HashMap<>() {{
            put("Y", 1);
            put("F", 2);
            put("O", 3);
        }};

        int n = Integer.parseInt(st.nextToken());
        int people = game.get(st.nextToken());
        int result = 0;

        for (int i = 0; i < n; i++) {
            String name = br.readLine();

            player.add(name);

            if(player.size() - (result * people) == people) {
                result++;
            }
        }
        System.out.println(result);
    }
}
