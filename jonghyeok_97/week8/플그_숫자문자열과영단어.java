package jonghyeok_97.week8;

public class 플그_숫자문자열과영단어 {

    public static void main(String[] args) {
        solution("one3");
    }

    public static int solution(String s) {
        int answer = 0;
        String replace = s.replace("zero", "0");
        String replace1 = replace.replace("one", "1");
        String replace2 = replace1.replace("two", "2");
        String replace3 = replace2.replace("three", "3");
        String replace4 = replace3.replace("four", "4");
        String replace5 = replace4.replace("five", "5");
        String replace6 = replace5.replace("six", "6");
        String replace7 = replace6.replace("seven", "7");
        String eight = replace7.replace("eight", "8");
        String nine = eight.replace("nine", "9");
        System.out.println(nine);
        return answer;
    }
}
