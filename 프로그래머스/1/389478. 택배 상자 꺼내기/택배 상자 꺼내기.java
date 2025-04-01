import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int next=0;
        int cur=num;
        int result=0;
        int[] list=new int[w];
        int dump=-1;
        int dis = 0;
        for(int i=0;i<w;i++){
            list[i]=dump+2;
            dump=list[i];
        }
        while(cur<=n){
            //행이 짝수, 홀수
            if((cur-1/w)%2==0){
                dis = (w - 1) - ((cur - 1) % w);
                next=cur+list[dis];
            }else{
                dis = (w - 1) - ((cur - 1) % w);
                next=cur+list[dis];
            }
            cur=next;
            result++;
        }
        return result;
    }
}