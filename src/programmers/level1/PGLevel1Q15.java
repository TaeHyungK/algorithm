package programmers.level1;

/**
 * 소수 찾기
 * 에라토스테네스의 체 사용
 * TODO 한번 읽어보고 꼭 이해하기!
 */
class PGLevel1Q15 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;

        int[] prime = new int[n + 1];
        int i, j;

        // 소수를 넣을 배열을 0으로 초기화
        // 0 - 소수, 1 - 소수가 아님
        for (i = 0; i <= n; i++) {
            prime[i] = 0;
        }
        prime[1] = 1;

        // 2부터 시작하여 배수들은 소수에서 제외
        for (i = 2; i <= n; i++) {
            for (j = 2; i * j <= n; j++) {
                prime[i * j] = 1;
            }
        }

        for (i = 1; i <= n; i++) {
            // 소수인 경우 answer 증가
            if (prime[i] != 1) answer++;
        }

        return answer;
    }
}
