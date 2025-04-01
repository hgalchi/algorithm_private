import java.util.*;
class Solution {
    public int solution(int n, int w, int num) {
        int cnt=0;
        int[] list=new int[w];
        int dump=-1;
        for(int i=0;i<w;i++){
            list[i]=dump+2;
            dump=list[i];
        }
        while(num<=n){
            num+=list[(w - 1) - ((num - 1) % w)];
            cnt++;
        }
        return cnt;
    }
}