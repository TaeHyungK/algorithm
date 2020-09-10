package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * atoi가 뭐야?
 * C 언어의 atoi 함수에 문자열을 넣어주면 정수가 반환됩니다.
 * 단, 문자열은 정수로 되어있어야 하며 알파벳 영문자, 특수 문자가 포함되면 해당 문자부터는 변환을 하지 않습니다.
 * 또한, 처음부터 숫자가 아니면 0으로 변환됩니다.
 */
public class StringToInteger {
    public static void main(String[] args) {
//        String str = "   -42";
//        String str = "4193 with words";
//        String str = "words and 987";
//        String str = "-91283472332";
//        String str = "3.14159";
//        String str = "+1";
        String str = "  -0012a42";
        System.out.println("result: " + myAtoi(str));
    }

    // 개인적으로 너무 힘들었던 문제.. 예외 케이스가 너무 많고 정규표현식을 잘 못써서 힘들었다..
    public static int myAtoi(String str) {
        // 첫번째 풀이
        // 정규표현식을 이용해 첫 시작이 문자인지 체크한다. (단, 예시에서 처럼 공백은 제외한다.)
        // 정규표현식을 이용해 음수를 포함한 숫자만으로 이루어진 애들을 뽑아온다.
        // 숫자 사이에 문자가 껴있는 경우 group() 이 나눠지게 되므로 첫번째 애만 뽑아서 int 타입으로 변환한 후 반환한다.
        int result = 0;

        str = str.trim();
        boolean isStartNum = Pattern.matches("^[+-]?[0-9]+.*", str);
        if (!isStartNum) return 0;

        String temp = "";
        Pattern pattern = Pattern.compile("[+-]?\\d+(\\.?\\d*)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            temp = matcher.group();
            break;
        }

        try {
            double d = Double.parseDouble(temp);
            result = (int) d;
        } catch (NumberFormatException nfe) {
            result = Integer.MIN_VALUE;
        }
        return result;
    }
}
