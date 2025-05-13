
import java.util.Stack;
// 1. Implement Stack using Array


class StackArray {
    int top = -1;
    int[] arr;

    StackArray(int size) {
        arr = new int[size];
    }

    void push(int x) {
        if (top == arr.length - 1) throw new RuntimeException("Stack overflow");
        arr[++top] = x;
    }

    int pop() {
        if (top == -1) throw new RuntimeException("Stack underflow");
        return arr[top--];
    }

    int peek() {
        return arr[top];
    }
}

// 1.b Implement Stack using Linked List
class StackLinkedList {
    private Node top;

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) throw new RuntimeException("Stack underflow");
        int value = top.data;
        top = top.next;
        return value;
    }

    public int peek() {
        if (top == null) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

// 2. Balanced Parentheses
static boolean isBalanced(String s) {
    Stack<Character> stack = new Stack<>();
    for (char ch : s.toCharArray()) {
        if (ch == '(' || ch == '[' || ch == '{') {
            stack.push(ch);
        } else if (ch == ')' && (stack.isEmpty() || stack.pop() != '(')) return false;
        else if (ch == ']' && (stack.isEmpty() || stack.pop() != '[')) return false;
        else if (ch == '}' && (stack.isEmpty() || stack.pop() != '{')) return false;
    }
    return stack.isEmpty();
}

// 3. Next Greater Element
static int[] nextGreater(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
        while (!stack.isEmpty() && stack.peek() <= nums[i]) stack.pop();
        res[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(nums[i]);
    }
    return res;
}

// 4. Previous Smaller Element
static int[] prevSmaller(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
        while (!stack.isEmpty() && stack.peek() >= nums[i]) stack.pop();
        res[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(nums[i]);
    }
    return res;
}

// 5. Min Stack
class MinStack {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    void pop() {
        if (mainStack.peek().equals(minStack.peek())) minStack.pop();
        mainStack.pop();
    }

    int getMin() {
        return minStack.peek();
    }
}

// 6. Evaluate Postfix
static int evalPostfix(String expr) {
    Stack<Integer> stack = new Stack<>();
    for (char ch : expr.toCharArray()) {
        if (Character.isDigit(ch)) stack.push(ch - '0');
        else {
            int b = stack.pop(), a = stack.pop();
            switch (ch) {
                case '+': stack.push(a + b); break;
                case '-': stack.push(a - b); break;
                case '*': stack.push(a * b); break;
                case '/': stack.push(a / b); break;
            }
        }
    }
    return stack.pop();
}

// 7. Stock Span
static int[] stockSpan(int[] prices) {
    Stack<Integer> stack = new Stack<>();
    int[] span = new int[prices.length];
    for (int i = 0; i < prices.length; i++) {
        while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) stack.pop();
        span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
        stack.push(i);
    }
    return span;
}

// 8. Trapping Rain Water
static int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0, water = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= leftMax) leftMax = height[left];
            else water += leftMax - height[left];
            left++;
        } else {
            if (height[right] >= rightMax) rightMax = height[right];
            else water += rightMax - height[right];
            right--;
        }
    }
    return water;
}

// 9. Largest Rectangle in Histogram
static int largestRectangle(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0, n = heights.length;
    for (int i = 0; i <= n; i++) {
        int h = i == n ? 0 : heights[i];
        while (!stack.isEmpty() && h < heights[stack.peek()]) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        stack.push(i);
    }
    return maxArea;
}

// 10. Daily Temperatures
static int[] dailyTemperatures(int[] T) {
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[T.length];
    for (int i = 0; i < T.length; i++) {
        while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
            int idx = stack.pop();
            res[idx] = i - idx;
        }
        stack.push(i);
    }
    return res;
}

// 11. 132 Pattern
static boolean find132pattern(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int s3 = Integer.MIN_VALUE;
    for (int i = nums.length - 1; i >= 0; i--) {
        if (nums[i] < s3) return true;
        while (!stack.isEmpty() && nums[i] > stack.peek()) {
            s3 = stack.pop();
        }
        stack.push(nums[i]);
    }
    return false;
}

public class StackProblem {

    public static void main(String[] args) {
        // Test StackArray
        StackArray stack = new StackArray(5);

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peek the top element
        System.out.println("Top element: " + stack.peek()); // Output: 30

        // Pop elements
        System.out.println("Popped element: " + stack.pop()); // Output: 30
        System.out.println("Popped element: " + stack.pop()); // Output: 20

        // Peek after popping
        System.out.println("Top element after popping: " + stack.peek()); // Output: 10

        // Push more elements
        stack.push(40);
        stack.push(50);

        // Pop all elements
        while (true) {
            try {
                System.out.println("Popped element: " + stack.pop());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage()); // Output: Stack underflow
                break;
            }
        }
    }
}
