package programmers.level1;

import java.util.*;

class PGLevel1Q14 {
    public static void main(String[] args) {
        solution(new String[] {"aaa", "bbb", "ccc", "Kim"});
    }

    public static String solution(String[] seoul) {
        List<String> temp = Arrays.asList(seoul);
        int index = temp.indexOf("Kim");
        return "김서방은 " + index + "에 있다";
    }
}
