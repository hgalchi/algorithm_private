import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int[] value=new int[]{a,b};
        int answer=0;
        
        while(value[0]-1/2!=value[1]-1/2){
            answer++;
            for(int i=0;i<2;i++){
                if(value[i]%2!=0){
                    value[i]+=1;
                }           
                value[i]/=2;
            }
        } return answer;  
    }
}