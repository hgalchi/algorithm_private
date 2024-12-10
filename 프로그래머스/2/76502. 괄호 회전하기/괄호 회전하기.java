import java.util.*;
class Solution {
    public boolean stackMethod(String str){
        Stack<Character> stack=new Stack<>();
         for(char c:str.toCharArray()){
                if(c=='('||c=='{'||c=='['){
                    stack.push(c);
                }else{
                    if(stack.isEmpty()){
                        return false;
                    }
                    char cur=stack.pop();
                    if((c==')'&&cur=='(')||(c=='}'&&cur=='{')||c==']'&&cur=='['){
                        continue;
                    }else{
                        return false;
                    }
                    
                }
            }return stack.isEmpty();
    }
    public int solution(String s) {
        int answer=0;
        for(int i=0;i<s.length();i++){
            s=s.substring(1)+s.charAt(0);
            if(stackMethod(s)){
                answer+=1;
            }
        }return answer;
    }
}