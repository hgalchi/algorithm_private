import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb=new StringBuilder();
        int[] dis=new int[]{10,12};
        int[] dis_count=new int[2];
        
        for(int n:numbers){
            if(n==0){
                n=11;
            }
            if(n%3==0){
                sb.append("R");
                dis[0]=n;
            }else if(n%3==1){
                sb.append("L");
                dis[1]=n;
            }else{
                for(int i=0;i<dis.length;i++){
                    int count=0;
                    int dist=Math.abs(n-dis[i]);

                    count+=dist%3;
                    count+=dist/3;
                    dis_count[i]=count;
                    }
                if(dis_count[0]==dis_count[1]){
                    if(hand.equals("left")){
                        dis[1]=n;
                        sb.append("L");
                    }else{
                        dis[0]=n;
                        sb.append("R");
                    }
                }else{
                    if(dis_count[0]<dis_count[1]){
                        sb.append("R");
                        dis[0]=n;
                    }else{
                        sb.append("L");
                        dis[1]=n;
                    }
                }
                }
                
                
                
            }
        return sb.toString();
        }
}