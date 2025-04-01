class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int sat=(6-startday+7)%7;
        int sun=(7-startday+7)%7;
        boolean event;
        int cnt=0;
        int d=0;
        int safe_time;
        for(int[] times:timelogs){
            safe_time=schedules[d++]+10;
            if(safe_time%100>=60){
                safe_time+=40;
            }
            event=true;
            for(int i=0;i<7;i++){
                if(i==sat ||i==sun){
                    continue;
                }
                
                if(safe_time<times[i]){
                    event=false;
                }
            }
            if(event) cnt++;
        }
        return cnt;
    }
}
