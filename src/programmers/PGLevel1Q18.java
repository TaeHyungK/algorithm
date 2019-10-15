package programmers;

/**
 * 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
 * n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 */
public class PGLevel1Q18 {
    public static void main(String[] args) {
        long n = 121L;
        System.out.println(solution(n));
    }

    public static long solution(long n) {
        double xValue = Math.sqrt(n);
        boolean isNumeric = Math.pow(Math.ceil(xValue), 2) == n;
        System.out.println("xValue= " + xValue + ", isNumeric: " + isNumeric);

        return isNumeric ? (long) Math.pow(xValue + 1, 2) : -1L;
    }
}
