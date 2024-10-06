package horanga.weeks8.first_attempt;

public class PG_JadenCase문자열만들기_horanga {

    public String solution(String s) {
        String[] arr = s.split(" ");
        String answer = "";

        for(int i = 0; i < arr.length; i++) {

            if(arr[i].length() == 0) answer += " ";

            else {
                answer += arr[i].substring(0, 1).toUpperCase();
                answer += arr[i].substring(1, arr[i].length()).toLowerCase();
                answer += " ";
            }
        }

        if(s.substring(s.length() -1, s.length()).equals(" ")) return answer;

        return answer.substring(0, answer.length() - 1);
    }
}
