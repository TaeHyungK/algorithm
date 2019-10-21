package programmers.level1;

class PGLevel1Q13 {
    public boolean solution(String s) {
        boolean answer = false;
        if (s.length() == 4 || s.length() == 6) {
            try {
                int temp = Integer.parseInt(s);
                answer = true;
            } catch (Exception e) {
                answer = false;
            }
        }
        return answer;
    }
}
