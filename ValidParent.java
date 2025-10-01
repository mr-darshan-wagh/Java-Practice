import java.util.Stack;

class ValidParent {
    public static void main(String[] args) {
       System.out.println(isValid("{{}}"));

    }
    
public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // If it's an opening bracket, push it
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // If it's a closing bracket
            else {
                if (stack.isEmpty()) return false;  // No matching opening
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // If stack is empty, all brackets matched
        return stack.isEmpty();
    }
}
