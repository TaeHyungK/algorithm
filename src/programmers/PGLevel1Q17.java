package programmers;

import java.util.Arrays;

/**
 * 함수 solution은 정수 n을 매개변수로 입력받습니다.
 * n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
 * 예를들어 n이 118372면 873211을 리턴하면 됩니다.
 */
public class PGLevel1Q17 {
    public static void main(String[] args) {
        long n = 118372L;
        solution(n);
    }

    public static long solution(long n) {
        long answer = 0;
        int length = (int) (Math.log10(n) + 1);

        long[] arrays = new long[length];
        for (int i = 0; i < length; i++) {
            int digit = (int) Math.pow(10, i);
            long value = (long) (n / digit % 10);

            arrays[i] = value;
        }

        Arrays.sort(arrays);

        for (int i = 0; i < length; i++) {
            int digit = (int) Math.pow(10, i);
            answer += arrays[i] * digit;
        }

        return answer;
    }
}
