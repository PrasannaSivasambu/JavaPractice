import java.util.Stack;

public class BalancedBrackets {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // Instead of pushing opening brackets, push expected closing ones
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                // If stack is empty or character doesn't match expected
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        // If everything matched, stack should be empty
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[()]}")); // true
        System.out.println(isValid("{([(}]")); // false
    }
}
