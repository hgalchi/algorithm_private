import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String,Integer> map=new HashMap<>();
        int i=0;
        for(String user:name){
            map.put(user,yearning[i++]);
        }
        
        i=0;
        for(String[] users:photo){
            int sum=0;
            for(String user: users){
                if(map.containsKey(user)){
                    sum+=map.get(user);
                }
            }
            answer[i++]=sum;
        }
        
        return answer;
    }
}