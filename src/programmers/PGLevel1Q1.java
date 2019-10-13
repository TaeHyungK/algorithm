package programmers;

import java.util.Arrays;

class PGLevel1Q1 {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;
        while (i < completion.length) {
            if (participant[i].equals(completion[i])) {
                i++;
            } else {
                answer = participant[i];
                break;
            }
        }

        if (answer.isEmpty()) {
            answer = participant[participant.length - 1];
        }

        return answer;
    }
}
