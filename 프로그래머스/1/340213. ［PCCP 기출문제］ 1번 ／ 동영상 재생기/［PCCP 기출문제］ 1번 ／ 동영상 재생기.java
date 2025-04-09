class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video_ss=toConvertSec(video_len);
        int pos_ss=toConvertSec(pos);
        int start_ss=toConvertSec(op_start);
        int end_ss=toConvertSec(op_end);
        
        for(String command:commands){
        if(pos_ss>=start_ss&&pos_ss<=end_ss){
            pos_ss=end_ss;
        }
            if(command.equals("next")){
                pos_ss=pos_ss+10>video_ss?video_ss:pos_ss+10;
            }else{
                pos_ss=pos_ss-10<0?0:pos_ss-10;
            }
        }
        if(pos_ss>=start_ss&&pos_ss<=end_ss){
            pos_ss=end_ss;
        }
        return String.format("%02d:%02d",pos_ss/60,pos_ss%60);
        
    }
    private int toConvertSec(String time){
        String[] str=time.split(":");
        return Integer.parseInt(str[0])*60+Integer.parseInt(str[1]);
    }
}