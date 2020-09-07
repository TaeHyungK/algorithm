package leetcode;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
//        int[] nums = {1,3,1,-1,3};
        System.out.println("result: " + singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        // 첫번째 풀이
        // nums 배열을 정렬한 후 for 문을 돌며 비교할 값(comparingItem) 과 현재 값 (nums[i]) 이 다른지 체크하여 다를 경우 findingCount를 증가시킨다.
        // 다음 또 비교했는데 findingCount가 2가 되어버린 경우 compairingItem이 Single 인 값이 된다.
//        if (nums.length == 1) return nums[0];
//
//        Integer result = null; // 초기값을 -1로 할 경우 result 가 실제로 -1일 때에 대한 구분을 할 수 없어 객체화 함.
//        Arrays.sort(nums);
//
//        int findingCount = 0;
//        int comparingItem = nums[0];
//        for (int i = 1; i < nums.length - 1; i++) {
//            if (i == 1 && comparingItem != nums[i]) {
//                // 처음 비교하자마자 다른 값인 경우
//                result = comparingItem;
//                break;
//            }
//
//            if (comparingItem != nums[i]) {
//                findingCount++;
//
//                if (findingCount >= 2) {
//                    result = comparingItem;
//                    break;
//                }
//            } else {
//                // 같을 경우 0으로 초기화
//                findingCount = 0;
//            }
//            comparingItem = nums[i];
//        }
//
//        // 마지막 값이 혼자인 경우
//        result = result == null ? nums[nums.length - 1] : result;
//        return result;

        // 두번째 풀이
        // 자료구조 `Set` 을 사용해 같은게 있는 경우 지우고, 없을 경우 추가한다.
        if (nums.length == 1) return nums[0];
        Set<Integer> data = new HashSet<>();
        for (int num : nums) {
            if (data.contains(num)) {
                data.remove(num);
            } else {
                data.add(num);
            }
        }

        int result = -1;
        for (int num : data) {
            result = num;
        }
        return result;
    }
}
