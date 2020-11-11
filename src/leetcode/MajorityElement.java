package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
//        int[] nums = {3, 2, 3};
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("result: " + majorityElement(nums));
    }

    private static int majorityElement(int[] nums) {
        int result = Integer.MIN_VALUE;

        // 첫번째 풀이
        // 해당 값들의 갯수를 체크해 `Map` 에 저장 한다.
        // [ 단, 문제에 다수 요소는 n / 2 라고 하는데 n/2를 잘못 표기했다 생각하고
        // 과반수 갯수 이상이 체크되면 그 값이 majority Element 이다. ]
        // 만들어진 map 을 iterate 하며 가장 큰 key를 찾는다.

        // key: 값, value: 갯수
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            if (count >= (nums.length / 2)) {
                return num;
            }

            map.put(num, count + 1);
        }

        int count = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            int temp = count;
            count = Integer.max(count, map.get(key));

            if (temp != count) {
                result = key;
            }
        }

        return result;
    }
}
