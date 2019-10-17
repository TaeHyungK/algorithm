package programmers;

/**
 * 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
 * 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
 * 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
 */
public class PGLevel1Q24 {
    public static void main(String[] args) {
        int x = 13;
        System.out.println(solution(x));
    }

    public static boolean solution(int x) {
        int length = (int) (Math.log10(x) + 1); // 자릿수 구함

        // 각 자릿수 array 저장
        int[] num = new int[length];
        for (int i = 0; i < length; i++) {
            int digit = (int) Math.pow(10, i);
            int value = x / digit % 10;

            num[i] = value;
        }

        int sum = 0;
        for (int temp : num) {
            sum += temp;
        }

        // Exception 방어 처리
        if (sum == 0) return false;

        return x % sum == 0;
    }
}
