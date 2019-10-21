package programmers.level1;

class PGLevel1Q11 {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toUpperCase();

        int pCount = 0;
        int yCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ('P' == s.charAt(i)) {
                pCount++;
            } else if ('Y' == s.charAt(i)) {
                yCount++;
            }
        }

        return pCount == yCount;
    }
}
