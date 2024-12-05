import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        //오름차순 정렬
        PriorityQueue<Long> q=new PriorityQueue<>();
        for(int s:scoville){
            q.offer((long)s);
        }
        //k의 최대길이 가 int값을 오버할 수 있다. 
        long sum=0;
        int answer=0;
        
        //시간복잡도 NlogN
        while(!q.isEmpty()){
            //스코빌 지수를 비교
            if(q.peek()<K){
                answer++;
                sum=q.poll()+(q.poll()*2);
                q.offer(sum);
            }else{
                return answer;
            }
            if(q.size()==1){
                if(q.peek()<K){
                    return -1;
                }
            }
        }
        return -1;
    }
}