class Solution {
    static int anwser=0;
    static int[] numbers;
    static int target;
    static int sum=0;
    static int level=0;
    static int answer=0;
    
    public int solution(int[] n, int t) {
        this.numbers=n;
        this.target=t;
        
        dfs(sum,level);
        return answer;
    }
    
    public void dfs(int sum,int level){
        if(level==numbers.length){
            if(sum==target){
                answer++;
            }return;
        }
            
                dfs(sum-numbers[level],level+1);
                dfs(sum+numbers[level],level+1);
        
    }
}