package jonghyeok_97.week9;

public class 플그_JadenCase만들기 {

    public String solution(String s) {
        String answer = "";
        String[] str = s.toLowerCase().split("");
        boolean flag = true;

        for (String ss : str) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }
        return answer;
    }

}
