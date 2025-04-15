import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        long[] sum=new long[3];
        for(int i=0;i<queue1.length;i++){
            q1.add(queue1[i]);
            sum[1]+=queue1[i];
            q2.add(queue2[i]);
            sum[2]+=queue2[i];
        }
        int size=q1.size();
        
        int i=0;
        while(i<=size*3){
            if(sum[1]==sum[2]) break;
            if(sum[1]>sum[2]){
                int n=q1.poll();
                q2.add(n);
                sum[1]-=n;
                sum[2]+=n;
            }else{
                int n=q2.poll();
                q1.add(n);
                sum[2]-=n;
                sum[1]+=n;
            }
            i++;
            
        }
        return i>=(size*3)?-1:i;
    }
}