package jonghyeok_97.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BOJ_수찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = Stream.of(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        int m = Integer.parseInt(br.readLine());
        List<Integer> list1 = Stream.of(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int num : list1) {
            if (binarySearch(num, list)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    private static boolean binarySearch(int here, List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(here < list.get(mid)) {
                end = mid - 1;
            }
            if(here > list.get(mid)) {
                start = mid + 1;
            }
            if(here == list.get(mid)) {
                return true;
            }
        }
        return false;
    }
}
