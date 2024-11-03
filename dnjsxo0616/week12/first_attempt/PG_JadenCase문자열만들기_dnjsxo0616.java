package dnjsxo0616.week12.first_attempt;

public class PG_JadenCase문자열만들기_dnjsxo0616 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean check = true;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                check = true;
            } else {
                if (check) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                check = false;
            }
        }
        return sb.toString();
    }
}
