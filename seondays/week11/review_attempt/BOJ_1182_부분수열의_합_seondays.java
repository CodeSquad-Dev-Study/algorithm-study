package week11.review_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의_합_seondays {

    static int result;
    static int n;
    static int s;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        solution(0, 0);

        if (s == 0) {
            System.out.println(result - 1);
            return;
        }

        System.out.println(result);
    }

    public static void solution(int index, int sum) {
        if (index == list.length) {
            if (sum == s) {
                result++;
            }
            return;
        }

        solution(index + 1, sum);

        solution(index + 1, sum + list[index]);
    }
}
