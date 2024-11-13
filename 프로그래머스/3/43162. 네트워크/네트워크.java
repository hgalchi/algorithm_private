import java.util.*;

class Solution {
   
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        int num = 0;

        //모든 정점을 돌면서 방문하지 않은 정점을 탐색
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visited[i]=true;
                num++;
                while (!q.isEmpty()) {
                    int cur=q.poll();
                    //방문하지 않았고 현재 정점과 간선으로 연결되어 있는 정점일 경우
                    for (int j = 0; j < n; j++) {
                        if (!visited[j] && computers[cur][j] == 1) {
                            visited[j]=true;
                            q.offer(j);
                        }
                    }
                }
            }


        }
        System.out.println(num);
        return num;
    }
}