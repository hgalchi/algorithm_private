
import java.util.*;
class Solution {

    public static void main(String[] args) {
        int[] answer=new Solution().solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        System.out.println(answer[0] + ":" + answer[1]);
    }
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        PriorityQueue<Integer> pqRev=new PriorityQueue<>(Collections.reverseOrder());
        for(String s:operations){
            String[] str = s.split(" ");
            if(str[0].equals("I")){
                int n=Integer.parseInt(str[1]);
                pq.offer(n);
                pqRev.offer(n);
            }else{
                if(str[1].equals("1")){
                    if(!pqRev.isEmpty()){
                        int max=pqRev.poll();
                        pq.remove(max);
                    }
                }else{
                    if(!pq.isEmpty()){
                        int min=pq.poll();
                        pqRev.remove(min);
                    }
                }
            }
        }

        int[] answer = new int[2];
        answer[0]=!pqRev.isEmpty()?pqRev.poll():0;
        answer[1]=!pq.isEmpty()?pq.poll():0;

        return answer;

    }
}