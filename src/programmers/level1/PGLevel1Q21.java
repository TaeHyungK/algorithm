package programmers.level1;

/**
 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
 * 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
 * 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
 *
 * FIXME 유클리드 호제법 사용
 */
public class PGLevel1Q21 {
    public static void main(String[] args) {
        int n = 3;
        int m = 12;
        System.out.println(solution(n, m));
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] = n >= m ? gcd(n, m) : gcd(m, n); // 최대 공약수
        answer[1] = n * m / answer[0]; // 최소 공배수

        return answer;
    }

    /**
     * 최대공약수 구하는 메소드
     * @param a 최초 호출 시 - big value
     * @param b 최초 호출 시 - small value
     * @return int 최소공배
     */
    private static int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a%b);
    }
}
