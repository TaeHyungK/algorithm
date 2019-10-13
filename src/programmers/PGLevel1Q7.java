package programmers;

import java.util.*;

public class PGLevel1Q7 {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(arr[0]);
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            if (arr[i] != arr[j]) {
                list.add(arr[j]);
            }
        }

        return convertListToArray(list);
    }

    private int[] convertListToArray(ArrayList<Integer> arrayList) {
        int[] result = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }

        return result;
    }
}
