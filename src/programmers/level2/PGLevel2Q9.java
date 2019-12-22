package programmers.level2;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 문제 설명
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 *
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * 013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 * 입출력 예
 * numbers	return
 * 17	3
 * 011	2
 * 입출력 예 설명
 * 예제 #1
 * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 *
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 *
 * 11과 011은 같은 숫자로 취급합니다.
 */

public class PGLevel2Q9 {
    public static void main(String[] args) {
        String numbers = "17";
        System.out.println(solution(numbers));
    }

    static String[] mStrArray = null;

    public static int solution(String numbers) {
        int answer = 0;

        mStrArray = numbers.split("");
        Stack<Integer> stack = new Stack<>();
        makeWord(mStrArray.length, stack, mStrArray.length);


        return answer;
    }

    private static void makeWord(int size, Stack<Integer> stack, int r) {
        String[] result = null;
        if (r == 0) {
            result = new String[stack.size() + 1];
            for (int i = 0; i < stack.size(); i++) {
                System.out.print(mStrArray[i]);
            }
        }

        int smallest = stack.isEmpty() ? 0 : stack.lastElement() + 1;

        for (int i = smallest; i < size; i++) {
            stack.push(i);
            makeWord(size, stack, r - 1);
            stack.pop();
        }
    }

    private static boolean checkPrime(int num) {
        boolean result = false;



        return result;
    }

    /**
     * 에라토스테네스의 체를 이용해 소수 찾기
     * @param size 숫자의 범위
     * @return
     */
    private static ArrayList<Integer> getPrime(int size) {
        boolean[] prime = new boolean[size + 1];
        for (int i = 0; i <= size; i++) {
            prime[i] = true;
        }
        prime[1] = false;


        for (int i = 2; i <= size; i++) {
            for (int j = 2; i * j <= size; j++) {
                prime[i * j] = false;
            }
        }

        ArrayList<Integer> primeList = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            if (prime[i]) {
                primeList.add(i);
            }
        }

        return primeList;
    }
}
