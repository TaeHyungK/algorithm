package leetcode;

/**
 * 제약 사항
 * - 공간복잡도가 O(1)을 유지해야 한다.
 * - 반환하는 것이 아닌 s 배열 자체의 순서를 바꿔야 한다.
 */
public class ReverseString {
    public static void main(String[] args) {
//        char[] s = {'h','e','l','l','o'};
        char[] s = {'H','a','n','n','a','h'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        // 첫번째 풀이
        // left는 증가, right는 감소하면서 서로 자리를 스왑하면 된다.
        // 단, left < right 인 경우 break 한다.
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
