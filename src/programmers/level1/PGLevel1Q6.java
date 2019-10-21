package programmers.level1;

class PGLevel1Q6 {
    public String solution(String s) {
        String answer = "";
        if (s.length() <= 1) {
            return s;
        }
        int midIndex = s.length() / 2;
        // 짝수인 경우
        if (s.length() % 2 == 0) {
            answer = s.substring(midIndex - 1, midIndex + 1);
        } else { // 홀수인 경우
            answer = s.substring(midIndex, midIndex + 1);
        }
        return answer;
    }
}
