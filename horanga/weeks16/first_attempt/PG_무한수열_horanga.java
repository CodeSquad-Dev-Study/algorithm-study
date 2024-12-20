package horanga.weeks16.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PG_무한수열_horanga {

    static Map<Long, Long> map = new HashMap<>();
    static int p,q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

//		dp = new long[(int) (n+1)];

        System.out.println(solve(n));

    }

    static long solve(long num) {

        if(num==0) return 1;
        if(map.containsKey(num)) return map.get(num);

        long a= (long)Math.floor(num/p);
        long b= (long)Math.floor(num/q);

        map.put(num, solve(a)+solve(b));
        return map.get(num);
}
}
