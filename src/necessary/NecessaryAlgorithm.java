package necessary;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 필수로 알고 있어야할 알고리즘
 */
public class NecessaryAlgorithm {
    public static void main(String[] args) {

        NecessaryAlgorithm algorithm = new NecessaryAlgorithm();

        int size = 200;
        System.out.println("소수 찾기 범위= " + size + ", result= " + algorithm.getPrime(size));
        String str = "((()))()()(())";
        System.out.println("올바른 괄호 체크 str= " + str + ", result= " + algorithm.isCorrected(str));
        str = "aaabbbaacce";
        System.out.println("문자열 압축하기 str= " + str + ", result= " + algorithm.strCompress(str));
        str = "level";
        System.out.println("회문 체크 str= " + str + ", result= " + algorithm.isPalindrome(str));
        str= "abacde";
        System.out.println("가장 긴 회문 문자열의 길이 구하기 str= " + str + ", result= " + algorithm.getLongestPalindrome(str));

        System.out.println("=======================================");
        System.out.println("소수구하기 = " + algorithm.getPrimeTest(200));
        System.out.println("올바른 괄호 체크 = " + algorithm.isCorrectedTest("()(())()"));
        System.out.println("문자열 압축하기 = " + algorithm.strCompressTest("aabddeffabbffeeeee"));
        System.out.println("가장 긴 회문 문자열 구하기 = " + algorithm.getPalindrome("aaabbbaacce"));
    }

    /**
     * 소수 구하기
     * @param size 범위
     * @return
     */
    private ArrayList<Integer> getPrime(int size) {
        ArrayList<Integer> result = new ArrayList<>();

        // true - 소수가 아님, false - 소수
        boolean[] temp = new boolean[size + 1];
        // 1은 소수가 아님
        temp[1] = true;

        for (int i = 2; i <= size; i++) {
            for (int j = 2; j * i <= size; j++) {
                temp[i * j] = true;
            }
        }

        for (int i = 1; i <= size; i++) {
            // false 인 경우 소수
            if (!temp[i]) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * 올바른 괄호 체크
     * @param str
     * @return
     */
    private boolean isCorrected(String str) {
        boolean isCorrect = false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char item = str.charAt(i);
            if (item == '(') {
                stack.push(item);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.pop() != '(') {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            isCorrect = true;
        }

        return isCorrect;
    }

    /**
     * 문자열 압축하기 (같은 문자열을 숫자로 표현하여 압축)
     * @param str
     * @return
     */
    private String strCompress(String str) {
        if (str.length() <= 1) return str;

        // 중복된 글자갯수
        int count = 1;
        while (count < str.length()
                && str.charAt(0) == str.charAt(count)) {
            count++;
        }

        String lengthStr = count > 1 ? String.valueOf(count) : "";
        return lengthStr + str.substring(0,1) + strCompress(str.substring(count));
    }

    /**
     * 회문 체크 (앞으로 읽어도 뒤로 읽어도 같은 글자)
     * api 사용
     * @param str
     */
    private boolean isPalindrome(String str) {
        String reverseStr = new StringBuilder(str).reverse().toString();
        return str.equals(reverseStr);
    }

    /**
     * 가장 긴 회문 문자열의 길이 구하기
     * 다만, 시간 복잡도가 O(n^2) 이므로 Manacher 알고리즘(O(n))을 이해하고 풀어야함..
     * @param str
     * @return
     */
    private int getLongestPalindrome(String str) {
        String palindrome = "";
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j <= str.length(); j++) {
                StringBuffer strBuffer = new StringBuffer();
                strBuffer.append(str.substring(i, j));
                if (str.substring(i, j).equals(strBuffer.reverse().toString())) {
                    palindrome = strBuffer.length() > result ? strBuffer.toString() : palindrome;
                    result = palindrome.length();
                }
            }
        }

        return result;
    }


    private ArrayList<Integer> getPrimeTest(int size) {
        ArrayList<Integer> result = new ArrayList<>();

        boolean[] temp = new boolean[size + 1];
        temp[1] = true;
        for (int i = 2; i <= size; i++) {
            for (int j = 2; j * i <= size; j++) {
                temp[i * j] = true;
            }
        }

        for (int i = 1; i <= size; i++) {
            if (!temp[i]) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean isCorrectedTest(String str) {
        boolean result = false;
        if (str.length() <= 1) {
            return false;
        }


        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char item = str.charAt(i);
            if (item == '(') {
                stack.push(item);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.pop() != '(') {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            result = true;
        }

        return result;
    }

    private String strCompressTest(String str) {
        String result = "";

        if (str.length() <= 1) {
            return str;
        }

        int count = 1;
        while (count < str.length()
                && str.charAt(0) == str.charAt(count)) {
            count++;
        }

        String lengthStr = count > 1 ? String.valueOf(count) : "";
        return lengthStr + str.substring(0, 1) + strCompressTest(str.substring(count));
    }

    private String getPalindrome(String str) {
        String result = "";
        int longest = 0;
        if (str.length() <= 1) {
            return str;
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j <= str.length(); j++) {
                StringBuffer strBuf = new StringBuffer();
                strBuf.append(str.substring(i, j));
                if (str.substring(i, j).equals(strBuf.reverse().toString())) {
                    result = strBuf.length() > longest ? strBuf.toString() : result;
                    longest = result.length();
                }
            }
        }

        return result;
    }
}
