import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        List<Double[]> list=new ArrayList<>();
        for(int i=1;i<=N;i++){
            int try_count=0;
            int suc_count=0;
            for(int stage:stages){
                if(i==stage) try_count++;
                if(i<=stage) suc_count++;
            }
            if(suc_count==0){
                list.add(new Double[]{(double)i,(double)0});
            }else{
                list.add(new Double[]{(double)i,(double)try_count/suc_count});
            }
        }
        Collections.sort(list, Comparator
    .comparing((Double[] a) -> a[1])
                         .reversed()
    .thenComparing((Double[] a) -> a[0])
);
        int[] answer=new int[N];
        for(int i=0;i<answer.length;i++){
            answer[i]=list.get(i)[0].intValue();            
        }
        return answer;
    }
}