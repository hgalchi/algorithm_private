import java.util.*;
class Solution {
    public int solution(int n, int k) {
        String[] str=Integer.toString(n,k).split("0");
        int answer=0;
        
        for(int i=0;i<str.length;i++){
            if(!str[i].isEmpty()&&isMinority(str[i])){
                answer++;
            }
        }
        return answer;
    }
    private boolean isMinority(String num){
    long value = Long.parseLong(num);
    if (value <= 1) return false;  
    for (long i = 2; i * i <= value; i++) {
        if (value % i == 0) return false;
    }
    return true;
}
}