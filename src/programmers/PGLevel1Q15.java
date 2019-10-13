package programmers;

class PGLevel1Q15 {
    public int solution(int n) {
        int answer = 0;

        int[] prime = new int[n + 1];
        int i, j;

        for (i = 0; i <= n; i++) {
            prime[i] = 0;
        }
        prime[1] = 1;

        for (i = 2; i <= n; i++) {
            for (j = 2; i * j <= n; j++) {
                prime[i * j] = 1;
            }
        }

        for (i = 1; i <= n; i++) {
            if (prime[i] != 1) answer++;
        }

        return answer;
    }
}
