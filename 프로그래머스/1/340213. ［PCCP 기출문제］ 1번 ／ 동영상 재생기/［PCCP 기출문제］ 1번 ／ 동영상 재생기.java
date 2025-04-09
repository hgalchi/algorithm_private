import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len=Integer.parseInt(video_len.replace(":",""));
        Integer cur=Integer.parseInt(pos.replace(":",""));
        int start=Integer.parseInt(op_start.replace(":",""));
        int end=Integer.parseInt(op_end.replace(":",""));
        
        for(String command:commands){
            if(start<=cur&&cur<=end){
                cur=end;
            }
            if(command.equals("next")){
                cur+=10;
                if(cur%100>=60) cur+=40;
                if(cur>=len) cur=len;
            }else{
                cur-=10;
                if(cur%100>=60) cur-=40;
                if(cur<=0) cur=0;
            }
        }
         if(start<=cur&&cur<=end){
                cur=end;
            }
        String cur_time=cur.toString();
        while(cur_time.length()<4){
            cur_time="0"+cur_time;
        }
        String answer=cur_time.substring(0,2)+":"+cur_time.substring(2,4);
        return answer;
    }
}