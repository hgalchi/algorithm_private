import java.util.*;
class Solution {
    int[] numbers;
    int target;
    int count=0;
    
    public int solution(int[] numbers, int target) {
        this.numbers=numbers;
        this.target=target;
        dfs(0,0);
        return count;
    }
    private void dfs(int level,int sum){
        if(level==numbers.length){
            if(sum==target) count++;
            return;
        }
        dfs(level+1,sum+numbers[level]);
        dfs(level+1,sum-numbers[level]);
    }
}