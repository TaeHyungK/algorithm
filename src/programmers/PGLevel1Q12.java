package programmers;

import java.util.*;

class PGLevel1Q12 {
    public String solution(String s) {
        String answer = "";
        String[] splitS = s.split("");
        List<String> listS = Arrays.asList(splitS);
        Collections.sort(listS);
        Collections.reverse(listS);

        for (int i = 0; i < listS.size(); i++) {
            answer += listS.get(i);
        }

        return answer;
    }
}
