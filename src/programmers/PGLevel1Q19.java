package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
 * 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
 * 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
 */
public class PGLevel1Q19 {
    public static void main(String[] args) {
        int[] arr = {10};
        System.out.println(solution(arr));
    }

    public static int[] solution(int[] arr) {
        if (arr.length <= 1) return new int[]{-1};

        int[] answer = new int[arr.length - 1];

        ArrayList<Integer> tempList = (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(tempList);
        Integer minValue = tempList.get(0);

        ArrayList<Integer> fakeList = (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
        fakeList.remove(minValue);

        for (int i = 0; i < fakeList.size(); i++) {
            answer[i] = fakeList.get(i);
        }
        return answer;
    }
}
