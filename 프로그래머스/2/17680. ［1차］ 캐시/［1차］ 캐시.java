import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
       Queue<String> q=new LinkedList<>();
        int answer=0;
        if(cacheSize==0){
            return cities.length*5;
        }
        for(String city : cities){
            city=city.toLowerCase();
            if(q.contains(city)){
                answer+=1;
                q.remove(city);
                q.add(city);
            }else{
                if(q.size()==cacheSize){
                    q.poll();
                }
                q.add(city);
                answer+=5;
            }
        }return answer;
    }
}