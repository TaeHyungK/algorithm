package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;

        System.out.println("result: " + generateParenthesis(n));
    }

    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        makeParenthesis(0, 0, new StringBuilder(), n, result);
        return result;
    }

    private static void makeParenthesis(int left, int right, StringBuilder sb, int n, List<String> result) {
        if(left == n && right == n) {
            result.add(sb.toString());
            return;
        }

        if(left < n) {
            sb.append("(");
            System.out.println("left !! " + sb.toString());
            makeParenthesis(left + 1, right, sb, n, result);
            sb.deleteCharAt(sb.length() - 1); // 맨 뒷글자 제거
        }

        if(right < left) {
            sb.append(")");
            System.out.println("right !! " + sb.toString());
            makeParenthesis(left, right + 1, sb, n, result);
            sb.deleteCharAt(sb.length() - 1); // 맨 뒷글자 제거
        }
    }
}
