import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited=new boolean[n];
        int answer=0;
      
        for(int i=0;i<n;i++){
            if(!visited[i]){
                answer++;
                Queue<Integer> q=new LinkedList<>();
                q.offer(i);
                while(!q.isEmpty()){
                    int row =q.poll();
                    for(int col=0;col<n;col++){
                        if(computers[row][col]==1&&!visited[col]){
                            visited[row]=true;
                            q.offer(col);
                        }
                    }
                }
            }
            
        }return answer;
    }
}