package week10.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292_벌집_seondays {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int room = 1;
        int count = 0;

        while (true) {
            if (n <= room) {
                System.out.println(count + 1);
                return;
            }
            count++;
            room = room + 6 * count;
        }
    }
}
