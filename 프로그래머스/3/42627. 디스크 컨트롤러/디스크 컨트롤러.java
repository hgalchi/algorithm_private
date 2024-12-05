
import java.util.*;
class Solution {

    public static void main(String[] args) {
        new Solution().solution(new int[][]{{0, 3}, {1, 9}, {3, 5}});
    }
    public int solution(int[][] jobs) {
        //요청시간을 기준으로 오름차순 정렬
        Arrays.sort(jobs,(x,y)->x[0]-y[0]);
        //대기 큐 - 소요 시간을 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->x[1]-y[1]);

        int count =0;
        int stand_disk=0;
        int start_time =0;
        int total_time =0;

        while(count <jobs.length){
            //1. 현재 시점에 요청된 디스크를 대기 큐에 추가
            while (stand_disk < jobs.length && jobs[stand_disk][0] <= start_time) {
                pq.add(jobs[stand_disk]);
                stand_disk++;
            }
            //2. 대기 큐 디스크 실행
            if(!pq.isEmpty()){
                int[] cur=pq.poll();
                //System.out.println("디스크 시작시간:"+ start_time+"\t 디스크 소요시간:"+cur[1]);
                //디스크_시작시간+디스크_소요시간-디스크_요청시간
                total_time += start_time +cur[1]-cur[0];
                //디스크 종료시간 갱신
                start_time +=cur[1];
                //실행시킨 디스크 개수 증가
                count++;
            //실행시킬 디스크가 없는 경우
            }else{
                //현재 시점에 실행시킬 디스크가 없다면 다음 디스크의 요청시간으로 넘어간다. 이때 아무것도 안하는 시간은 전체 시간에 포함하지 않는다.
                start_time =jobs[count][0];
            }
        }return total_time /jobs.length;
    }
}