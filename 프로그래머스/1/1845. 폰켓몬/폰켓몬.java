import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int num :nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int size=nums.length/2;
        //map의 
        answer=map.size()>size?size:map.size();
        return answer;
    }
}