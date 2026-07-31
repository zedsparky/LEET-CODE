import java.util.Stack;

public class validParenthesis_20 {

    /*
     * Optimal Approach (Stack)
     *
     * Algorithm:
     * 1. Traverse the string.
     * 2. Push every opening bracket onto the stack.
     * 3. For every closing bracket:
     *      - If the stack is empty, return false.
     *      - Check whether the top of the stack matches it.
     *      - If it matches, pop it.
     *      - Otherwise, return false.
     * 4. After traversal, if the stack is empty, return true.
     *    Otherwise, return false.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Push opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {

                // No opening bracket available
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();

                // Matching brackets
                if ((top == '(' && ch == ')') ||
                    (top == '[' && ch == ']') ||
                    (top == '{' && ch == '}')) {

                    stack.pop();

                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(isValid("()"));       // true
        System.out.println(isValid("()[]{}"));   // true
        System.out.println(isValid("(]"));       // false
        System.out.println(isValid("([)]"));     // false
        System.out.println(isValid("{[]}"));     // true
    }
}