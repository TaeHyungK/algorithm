package programmers;

import java.util.Arrays;

/**
 * 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.
 * 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.
 */
public class PGLevel1Q26 {
    public static void main(String[] args) {
        int[][] arr1 = {{1}, {2}};
        int[][] arr2 = {{3}, {5}};
        System.out.println(solution(arr1, arr2));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];

            }
        }

        return answer;
    }
}
