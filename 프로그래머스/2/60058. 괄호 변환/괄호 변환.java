import java.util.*;

class Solution {
    public String solution(String w) {
        return convert(w);
    }

    private String convert(String w){
        if(w.equals("")) return "";
        int index = getBalance(w);
        String u = w.substring(0, index);
        String v = w.substring(index);

        if(isCollect(u)){
            return u + convert(v);
        } else {
            return "(" + convert(v) + ")" + reverse(u);
        }
    }

    private String reverse(String u){
        StringBuilder sb = new StringBuilder();
        u = u.substring(1, u.length() - 1);
        for (String ch : u.split("")) {
            if(ch.equals("(")) sb.append(")");
            if(ch.equals(")")) sb.append("(");
        }
        return sb.toString();
    }

    private boolean isCollect(String u){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < u.length(); i++){
            char c = u.charAt(i);
            if(c == '(') stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty(); // 수정된 부분
    }

   private int getBalance(String w) {
    int left = 0, right = 0;
    for (int i = 0; i < w.length(); i++) {
        if (w.charAt(i) == '(') left++;
        else right++;
        if (left == right) return i + 1;
    }
    return w.length(); // fallback
}

}
