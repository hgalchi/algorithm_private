import java.util.*;
class Solution {
    int[] root;
    public int find(int x){
        if(root[x]==x){
            return x;
        }return find(root[x]);
    }
    public void union(int x,int y){
        x=find(x);
        y=find(y);
        if(x>y){
            root[x]=y;
        }else{
            root[y]=x;
        }
    }
    public int solution(int n, int[][] computers) {
        root=new int[n];
        for(int i=0;i<n;i++){
            root[i]=i;
        }
        
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(computers[row][col]==1){
                    union(row,col);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            root[i]=find(i);
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(root[i]);
        }
        return set.size();
    }
}