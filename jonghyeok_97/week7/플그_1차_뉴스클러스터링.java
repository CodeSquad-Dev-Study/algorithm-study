package jonghyeok_97.week7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 플그_1차_뉴스클러스터링 {

    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> list1 = makeElement(str1);
        List<String> list2 = makeElement(str2);
        List<String> list3 = new LinkedList<>();
        list3 = list2;

        List<String> kyo = new ArrayList<>();
        List<String> hap = new ArrayList<>();

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list3.size(); j++) {
                String s = list3.get(j);
                if (list1.get(i).equals(s)) {
                    kyo.add(s);
                    list3.remove(s);
                    break;
                }
            }
        }
        for (String s : list1) {
            hap.add(s);
        }
        for (String s : list3) {
            hap.add(s);
        }
        if (hap.size() == 0 && kyo.size() == 0) {
            return 65536;
        }
        answer = (int) (((double) kyo.size() / hap.size()) * 65536);

        return answer;
    }

    public List<String> makeElement(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            String tmp = "";
            char ch = s.charAt(i);
            char ch2 = s.charAt(i + 1);
            if ('A' <= ch && ch <= 'Z' && 'A' <= ch2 && ch2 <= 'Z') {
                tmp += ch;
                tmp += ch2;
                list.add(tmp);
            }
        }
        return list;
    }

}
