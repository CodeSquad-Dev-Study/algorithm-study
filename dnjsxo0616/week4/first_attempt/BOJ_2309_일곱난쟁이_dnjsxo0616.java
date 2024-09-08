package dnjsxo0616.week4.first_attempt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309_일곱난쟁이_dnjsxo0616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dwarves = new int[9];
        for(int i=0; i<9; i++) {
            dwarves[i] = Integer.parseInt(br.readLine());
        }

        int sum = Arrays.stream(dwarves).sum();
        for(int i=0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                if(sum - dwarves[i] - dwarves[j] == 100) {
                    dwarves[i] = 0;
                    dwarves[j] = 0;
                    Arrays.sort(dwarves);
                    for(int k=2; k<9; k++) {
                        System.out.println(dwarves[k]);
                    }
                    return;
                }
            }
        }
    }
}
