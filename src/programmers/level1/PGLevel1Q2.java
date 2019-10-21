package programmers.level1;

import java.util.ArrayList;

class PGLevel1Q2 {
    public static int[] solution(int[] answers) {
        ArrayList<Integer> scores = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        int[] a = {1, 2, 3, 4, 5}; // 5
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10

        int scoreA = getScore(a, answers);
        scores.add(getScore(a, answers));
        int scoreB = getScore(b, answers);
        scores.add(getScore(b, answers));
        int scoreC = getScore(c, answers);
        scores.add(getScore(c, answers));

        int maxScore = Math.max(scoreA, Math.max(scoreB, scoreC));

        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) == maxScore) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static int getScore(int[] check, int[] answers) {
        int score = 0;

        for (int i = 0; i < answers.length; i++) {
            if (check[i % check.length] == answers[i % answers.length]) {
                score++;
            }
        }

        return score;
    }
}
