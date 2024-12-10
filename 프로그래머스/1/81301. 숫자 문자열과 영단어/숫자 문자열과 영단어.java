import java.util.*;
class Solution {
    public int solution(String s) {
        
        String[] alpabat={"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i=0;i<10;i++){
            s=s.replace(alpabat[i],""+i);
        }
        return Integer.parseInt(s);
    }
}