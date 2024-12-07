import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> map=new HashMap<>();
        
        for(String[] c:clothes){
            int n=map.getOrDefault(c[1],0)+1;
            map.put(c[1],n);
        }
        int answer=1;
        for(String key:map.keySet()){
            answer*=(map.get(key)+1);
        }
        return answer-1;
    }
}