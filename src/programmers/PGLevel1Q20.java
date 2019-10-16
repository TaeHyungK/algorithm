package programmers;

/**
 * 정수 num이 짝수일 경우 Even을 반환하고 홀수인 경우 Odd를 반환하는 함수, solution을 완성해주세요.
 */
public class PGLevel1Q20 {
    public static void main(String[] args) {
        int num = 0;
        System.out.println(solution(num));
    }

    public static String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}
