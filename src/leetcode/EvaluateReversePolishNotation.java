package leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
//        String[] tokens = {"2", "1", "+", "3", "*"};
//        String[] tokens = {"4", "13", "5", "/", "+"};
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("result: " + evalRPN(tokens));
    }

    private static int evalRPN(String[] tokens) {
        // 후위 표기법을 푸는 문제.
        // 연산자가 나오기 전에는 스택에 담고 연산자를 만나면 꺼내서 계산.
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            try {
                int value = Integer.parseInt(token);
                stack.push(value);
            } catch (NumberFormatException e) {
                // Exception 발생 시, 숫자가 아님. 즉 연산자.
                int first = stack.pop();
                int second = stack.pop();

                System.out.println("calc: " + first + " " + token + " " + second);
                int calc = calculate(first, second, token);
                stack.push(calc);
            }
        }

        return stack.pop();
    }

    private static int calculate(int first, int second, String operator) {
        switch (operator) {
            case "+":
                return second + first;
            case "-":
                return second - first;
            case "*":
                return second * first;
            case "/":
                return second / first;
            default:
                throw new RuntimeException("calculate() Error.");
        }
    }
}
