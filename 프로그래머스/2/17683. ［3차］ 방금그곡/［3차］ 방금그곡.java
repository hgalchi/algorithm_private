import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        
        String answerTitle="";
        int musicDuration=0;
        m=conver(m);
        
        for(String musicinfo:musicinfos){
            String[] info=musicinfo.split(",");
            String music=conver(info[3]);
            int start=converToMinute(info[0]);
            int end=converToMinute(info[1]);
            int duration=end-start;
            String title =info[2];
            StringBuilder sb=new StringBuilder();
            
            for(int i=0;i<duration;i++){
                sb.append(music.charAt(i%music.length()));
            }
            
            music=sb.toString();
            
            if(music.contains(m)&&musicDuration<duration){
                answerTitle=title;
                musicDuration=duration;
            }
    }
        return musicDuration!=0?answerTitle:"(None)";
}   
    
    private int converToMinute(String time){
        String[] times=time.split(":");
        int hour=Integer.parseInt(times[0].trim());
        int minute=Integer.parseInt(times[1].trim());
        return hour*60+minute;
    }
    
    private String conver(String music){
        return music.replace("C#","c")
            .replace("D#","d")
            .replace("F#","f")
            .replace("G#","g")
            .replace("B#","b")
            .replace("A#","a");
    }
}