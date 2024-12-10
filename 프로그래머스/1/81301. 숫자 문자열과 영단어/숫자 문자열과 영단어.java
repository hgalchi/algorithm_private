import java.util.*;
class Solution {
    public int solution(String s) {
        
        String[] dist={"0","1","2","3","4","5","6","7","8","9"};
        String[] alpabat={"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i=0;i<10;i++){
            s=s.replace(alpabat[i],dist[i]);
        }
        return Integer.parseInt(s);
    }
}