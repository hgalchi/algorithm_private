import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {

        List<Integer> list=new ArrayList<>();
        for(int i=0;i<diffs.length;i++){
            list.add(diffs[i]);
        }
        Collections.sort(list);
        int low=list.get(0);
        long low_sum=0;
        int high=list.get(list.size()-1);
        
        //모두 t인경우
        if(calculate(low,diffs,times)<=limit){
            return low;
        }
        while(low+1<high){
            int mid=(low+high)/2;
            long time_cur=calculate(mid,diffs,times);
            if(time_cur<=limit) high=mid;
            else low=mid;
        }
        return high;
    }
    
    private long calculate(int level,int[] diffs,int[] times){
        long time_cur=0;
        for(int i=0;i<diffs.length;i++){
            if(level>=diffs[i]){
                time_cur+=times[i];
            }else{
                int count=diffs[i]-level;
                time_cur+=(times[i-1]+times[i])*count+times[i];
            }
        }
        return time_cur;
    }
}