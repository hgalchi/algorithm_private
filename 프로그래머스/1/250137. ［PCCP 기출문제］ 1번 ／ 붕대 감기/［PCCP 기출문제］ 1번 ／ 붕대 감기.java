import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        //연속 횟수
        int cnt=0;
        //시전 시각
        int time=1;
        //현재 hp
        int cur=health;
        
        for(int[] attack:attacks){
            //연속 횟수
            cnt=attack[0]-time;
            
            //회복
            cur+=(cnt*bandage[1]);
            
            if(cnt>=bandage[0]){
                //추가회복량
                cur+=(cnt/bandage[0])*bandage[2];
            }
            
            cur=cur>health?health:cur;
            //공격
            cur-=attack[1];
            //캐릭터 dead
            if(cur<=0)return -1;

            //갱신
            time=attack[0]+1;
            cnt=0;
        }
        return cur;
    }
}