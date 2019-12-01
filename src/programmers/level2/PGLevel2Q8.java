package programmers.level2;

import java.util.*;

/**
 * 문제 설명
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 *
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 *
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 * 입출력 예
 * numbers	return
 * [6, 10, 2]	6210
 * [3, 30, 34, 5, 9]	9534330
 */
public class PGLevel2Q8 {
    public static void main(String[] args) {
        int[] numbers = new int[]{3, 30, 34, 5, 9};

        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        String answer = "";

        String[] temp = new String[numbers.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(temp, bubbleSort);
        for (String item : temp) {
            System.out.println("item: " + item);
            answer += item;
        }

        if (answer.startsWith("0")) {
            answer = "0";
        }

        return answer;
    }

    private static Comparator<String> bubbleSort = new Comparator<String>() {
        @Override
        public int compare(String cur, String next) {
            String first = cur + next;
            String second = next + cur;
            return second.compareTo(first);
        }
    };

    /**
     * 10으로 나눠서 하면 안됨!!
     */
//    private Comparator<Integer> bubbleComparator = new Comparator<Integer>() {
//        @Override
//        public int compare(Integer cur, Integer next) {
//            int curNum = cur;
//            int nextNum = next;
//            // 맨 앞자리 숫자
//            int curTopNum = 0;
//            int nextTopNum = 0;
//            // 10으로 나눈 횟수
//            int curCount = 0;
//            int nextCount = 0;
//
//            while (curNum > 0) {
//                curTopNum = curNum % 10;
//                curNum /= 10;
//                curCount++;
//            }
//            while (nextNum > 0) {
//                nextTopNum = nextNum % 10;
//                nextNum /= 10;
//                nextCount++;
//            }
//
//            if (curTopNum > nextTopNum) {
//                return -1;
//            } else if (curTopNum < nextTopNum){
//                return 1;
//            } else {
//                if ((curCount == 1 || nextCount == 1)
//                        && (cur % 10 == 0 || next % 10 == 0)) {
//                    // 첫 자리수가 같고, 비교하는 두 값이 모두 10으로 딱 떨어지는 경우
//                    // 숫자가 더 작은 것이 앞으로
//                    if (cur > next) {
//                        return 1;
//                    } else {
//                        return -1;
//                    }
//                } else {
//                    // 첫 자리수가 같고, 10으로 딱 나누어지는 수가 없는 경우
//                    // 숫자가 더 큰 것이 앞으로
//                    if (cur > next) {
//                        return -1;
//                    } else {
//                        return 1;
//                    }
//                }
//            }
//        }
//    };

}
