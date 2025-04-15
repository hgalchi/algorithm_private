import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
     int answer=0;
        char[][] map=new char[m][n];
        for(int i=0;i<m;i++){
            map[i]=board[i].toCharArray();
        }
        while(true){
            int remove_block=calculateBlock(map,m,n);
            if(remove_block==0){
                return answer; 
            }
            fillEmpty(map,m,n);
            answer+=remove_block;
        }
    }
    
    private void fillEmpty(char[][] map,int m, int n){
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(map[i][j]=='.'){
                    int u=i-1;
                    while(u>=0&&map[u][j]=='.'){
                        u--;
                    }
                    if(u>=0){
                    map[i][j]=map[u][j];
                    map[u][j]='.';
                        
                    }
                }
            }    
        }
        
    }
    private int calculateBlock( char[][] map,int m, int n){
        boolean[][] visited=new boolean[m][n];
        
//         블록을 하나씩 탐색하면서 탐색
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
            if(map[i][j]!='.'&&map[i][j]==map[i+1][j]&&map[i][j]==map[i][j+1]&&map[i][j]==map[i+1][j+1]){
                visited[i][j]=true;
                visited[i][j+1]=true;
                visited[i+1][j+1]=true;
                visited[i+1][j]=true;
            }
            }
        }
        
        int remove_block=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]){
                    map[i][j] = '.';   
                    remove_block++;
                }
            }
        }return remove_block;
    }
}