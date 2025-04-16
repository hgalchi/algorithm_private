import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
      
        int INF=987654321;
        int[][] map=new int[N+1][N+1];
       for(int i=0;i<map.length;i++){
           Arrays.fill(map[i],INF);
           map[i][i]=0;
       }
        for(int[] edge:road){
            int s=edge[0];
            int e=edge[1];
            int cost=edge[2];
            map[s][e]=Math.min(map[s][e],cost);
            map[e][s]=Math.min(map[e][s],cost);
        }
        
        for(int k=0;k<N+1;k++){
            for(int i=0;i<N+1;i++){
                for(int j=0;j<N+1;j++){
                    if(map[i][k]!=INF&&map[k][j]!=INF){
                        map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);
                    }
                }
            }
        }
        int answer=0;
        for(int i=1;i<map.length;i++){
            if(map[1][i]!=INF&&map[1][i]<=K){
                answer++;
            }
        } return answer;
    }
}