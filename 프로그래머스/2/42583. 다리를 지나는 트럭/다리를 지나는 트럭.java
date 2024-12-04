import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<bridge_length-1;i++){
            q.add(0);
        }
        int sum=truck_weights[0];
        //0번째 트럭 추가
        q.add(truck_weights[0]);
        
        int time=1;
        int index=1;
        int answer=1;
        while(!q.isEmpty()){
            answer++;
            sum-=q.poll();
            if(index<truck_weights.length){
                //다리가 버틸 수 있는 크기인 경우
                if(sum+truck_weights[index]<=weight){
                    sum+=truck_weights[index];
                    q.add(truck_weights[index]);
                    index++;
                }else{
                    q.add(0);
                }
            }
        }return answer;
    }
}