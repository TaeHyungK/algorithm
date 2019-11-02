package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class DemoTest {
    public static void main(String[] args) {
        int[] arrays = {-1, -3};
        System.out.println(solution(arrays));
    }

    public static int solution(int[] arrays) {
        int result = 1;

        Arrays.sort(arrays);
        HashSet<Integer> tempList = (HashSet<Integer>) Arrays.stream(arrays).boxed().collect(Collectors.toSet());

        for (int temp : tempList) {
            if (temp <= 0) {
                // 0 이하인 경우 다음 수로 넘어감
                continue;
            }
            if (result == temp) {
                result++;
            } else {
                break;
            }
        }

        return result;
    }
}
