package necessary;

import java.util.*;

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

        int n = 10;
        System.out.println("for문을 이용하지 않고 1~n까지의 합 구하기 n = " + n + ", result= " + algorithm.recursiveSum(n));
        n = 50;
        JumpingNumber jumpingNumber = new JumpingNumber();
        System.out.println("각 자리수가 1차이 나는 값 찾기(Jumping Number Sequenece)");
        jumpingNumber.printJumpingNumbers(n);

        System.out.println();
        algorithm.bubbleSort(new int[]{4, 3, 1, 5, 9});

        DecimalToBinary decimalToBinary = new DecimalToBinary();
        decimalToBinary.printBinary(5);

        RandomShuffle randomShuffle = new RandomShuffle();
        randomShuffle.printArrayShuffle(new int[]{4, 3, 1, 5, 9});

//        System.out.println("=======================================");
//        System.out.println("소수구하기 = " + algorithm.getPrimeTest(200));
//        System.out.println("올바른 괄호 체크 = " + algorithm.isCorrectedTest("()(())()"));
//        System.out.println("문자열 압축하기 = " + algorithm.strCompressTest("aabddeffabbffeeeee"));
//        System.out.println("가장 긴 회문 문자열 구하기 = " + algorithm.getPalindrome("aaabbbaacce"));
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

    private int recursiveSum(int n) {
        if (n == 1) return 1;
        else return n + recursiveSum(n - 1);
    }

    /**
     * 한 자릿수는 JumpingNumber로 취급
     */
    private static class JumpingNumber {
        public JumpingNumber() {

        }

        public void printJumpingNumbers(int n) {
            for (int i = 1; i <= 9 && i <= n; i++) {
                printJumpNo(i, n);
            }

            System.out.println();

            printOrderedJumpNo(n);
        }

        // BFS
        private void printJumpNo(int startNum, int n) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(startNum);

            while (!queue.isEmpty()) {
                startNum = queue.poll();
                int lastDigit = startNum % 10;

                if (startNum <= n) {
                    System.out.print(startNum + " ");

                    if (lastDigit == 0) {
                        queue.offer(startNum * 10 + (lastDigit + 1));
                    } else if (lastDigit == 9) {
                        queue.offer(startNum * 10 + (lastDigit - 1));
                    } else {
                        queue.offer(startNum * 10 + (lastDigit + 1));
                        queue.offer(startNum * 10 + (lastDigit - 1));
                    }
                }
            }
        }

        // BFS
        private void printOrderedJumpNo(int n) {
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= 9 && i <= n; i++) {
                queue.offer(i);
            }

            while (!queue.isEmpty()) {
                int startNum = queue.poll();
                int lastDigit = startNum % 10;
                
                if (startNum <= n) {
                    System.out.print(startNum + " ");

                    if (lastDigit == 0) {
                        queue.offer(startNum * 10 + (lastDigit + 1));
                    } else if (lastDigit == 9) {
                        queue.offer(startNum * 10 + (lastDigit - 1));
                    } else {
                        queue.offer(startNum * 10 + (lastDigit + 1));
                        queue.offer(startNum * 10 + (lastDigit - 1));
                    }
                }
            }
        }
    }

    private void bubbleSort(int[] items) {
        int length = items.length;
        int tmp;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (items[j] > items[j+1]) { // 앞원소가 더 크다면
                    tmp = items[j]; // 앞 원소 임시저장
                    items[j] = items[j+1]; // 앞자리에 뒷원소를 넣고
                    items[j+1] = tmp; // 뒷자리에 앞원소를 넣음
                }
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.println("bublleSort() " + items[i]);
        }
    }

    private static class DecimalToBinary {
        public DecimalToBinary() {

        }

        public void printBinary(int input) {
            String binaryStr = "";

            int quo = -1;
            int rem = -1;

            while (true) {
                quo = input / 2;
                rem = input % 2;
                binaryStr = rem + binaryStr;

                if (quo == 0) break;

                input = quo;
            }
            System.out.println("printBinary: " + binaryStr);
        }
    }

    private static class RandomShuffle {
        public RandomShuffle() {

        }
        public static void printArrayShuffle(int[] input) {
            for (int i = 0; i < input.length; i++) {
                int first = (int) (Math.random() * input.length);
                int second = (int) (Math.random() * input.length);

                int tmp = input[first];
                input[first] = input[second];
                input[second] = tmp;
            }

            for (int item : input) {
                System.out.print(item + " ");
            }
        }
    }
}
