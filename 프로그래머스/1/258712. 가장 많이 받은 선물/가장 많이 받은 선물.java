import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
       Map<String,Integer> hashMap=new HashMap<>();
        int n=friends.length;
        
        for(int i=0;i<friends.length;i++){
            hashMap.put(friends[i],i);
        }
        int[][] map=new int[n][n];
        int[] answer=new int[n];
        
        //맵 초기화
        for(String str:gifts){
            String a=str.split(" ")[0];
            String b=str.split(" ")[1];
            map[hashMap.get(a)][hashMap.get(b)]++;
        }
        
        
        for(int row=0;row<map.length;row++){
            for(int col=row;col<map[0].length;col++){
                if(row==col) continue;
                //row->col와 col->row인 경우 비교
                if(map[row][col]>map[col][row]){
                    answer[row]++;
                }else if(map[col][row]>map[row][col]){
                    answer[col]++;
                //동일한 경우 
                }else{
                    //선물지수 비교(준선물-받은선물)
                    int x=0,y=0;
                    for(int i=0;i<map.length;i++){
                        //준선물
                        x+=map[row][i];
                        y+=map[col][i];
                        
                        //받은 선물
                        x-=map[i][row];
                        y-=map[i][col];
                    }
                    if(x>y){
                        answer[row]++;
                    }else if(x<y){
                        answer[col]++;
                    }
                
            }
        }
        }
        int max=0;
        for(int x:answer){
            max=Math.max(max,x);
        }return max;
    }
}