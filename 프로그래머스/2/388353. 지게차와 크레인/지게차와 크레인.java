import java.util.*;
class Solution {
    int[] disr=new int[] {1,-1,0,0};
    int[] disc=new int[] {0,0,1,-1};
    public int solution(String[] storage, String[] requests) {
        
        char[][] map=new char[storage.length][storage[0].length()];
        for(int i=0;i<storage.length;i++){
            map[i]=storage[i].toCharArray();
        }
            
        for(String request:requests){
            List<int[]> removeContainer=new ArrayList<>();
            if(request.length()==2){
                for(int i=0;i<map.length;i++){
                    for(int j=0;j<map[0].length;j++){
                        if(map[i][j]==request.charAt(0)) removeContainer.add(new int[]{i,j});
                    }
                }
            }else{
                for(int i=0;i<map.length;i++){
                    for(int j=0;j<map[0].length;j++){
                        if(map[i][j]==request.charAt(0)){
                            boolean[][] visited=new boolean[map.length][map[0].length];
                            if(dfs(i,j,map,visited)) removeContainer.add(new int[]{i,j});
                        }
                        
                    }
                }
            }
            for(int[] container:removeContainer){
                map[container[0]][container[1]]='0';
            }
        }
        int answer=0;
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j]!='0') answer++;
            }
        }    
        return answer;
    }
    
    private boolean dfs(int row,int col,char[][] map,boolean[][] visited){
        boolean check=false;
        if(row==0||row==map.length-1||col==0||col==map[0].length-1){
            return true;
        }else{
            for(int i=0;i<4;i++){
                int nextr=row+disr[i];
                int nextc=col+disc[i];
                //다음 탐색 구간이 있는 경우 
                if(map[nextr][nextc]=='0'&&visited[nextr][nextc]==false){
                    visited[nextr][nextc]=true;
                    if(dfs(nextr,nextc,map,visited)){
                        check=true;
                    }
                }
            }
        }return check;
    }
}