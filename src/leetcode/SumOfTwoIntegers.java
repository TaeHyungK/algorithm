package leetcode;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;

        System.out.println("result: " + getSum(a, b));
    }

    private static int getSum(int a, int b) {
        // 보자마자 비트 연산으로 푸는 문제라고 생각했는데 비트 연산에 굉장히
        // 심하게 약하기 때문에 포기했다.. 대단하다..
        // 공식인 것 같다. 외워두면 좋을 듯하다.

        // 연산자 없이 덧셈하기.
        // xor은 각 자리의 비트가 0과 1일 경우 더해준다 -> 즉 그냥 덧셈용이다.
        // and는 각 자리의 비트가 1과 1일 경우를 알 수 있다 -> 즉 올림을 알기 위해 사용된다.
        // and가 있는 경우 left shift 를 통해 자릿수를 올려준다.
        // and의 결과가 0이 될 때 까지 반복하면 덧셈이 된다.

        // 1회차 a = 2, b = 3
        // xor = 0010 ^ 0011 = 0001 (1)
        // and = 0010 & 0011 = 0010 (2)
        // and left shift = 0100 (4)
        // 2회차 a = 1, b = 4
        // xor = 0001 ^ 0100 = 0101 (5)
        // and = 0001 & 0100 = 0000 (0)
        // and left shift = 0000 (0)
        // a = 5, b = 0 <- 조건에 의해 종료.

        int xor;
        int and;
        while (b != 0) {
            xor = a ^ b;
            and = a & b;
            and <<= 1;
            a = xor;
            b = and;
        }

        return a;
    }
}
