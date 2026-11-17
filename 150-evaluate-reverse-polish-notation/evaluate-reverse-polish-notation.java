import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b); // Integer division in Java naturally truncates toward zero
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}