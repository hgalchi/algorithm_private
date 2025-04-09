import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<String> stack = new Stack<>();
        
        for (String str : s.split("")) {
            if (!stack.isEmpty() && stack.peek().equals(str)) {
                stack.pop();  
            } else {
                stack.push(str);  
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}
