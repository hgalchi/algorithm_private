import java.util.*;
class Solution {
    int[] discounts=new int[]{10,20,30,40};
    List<int[]> emoticon_discount=new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {
        int[] cur_discount=new int[emoticons.length];
        dfs(cur_discount,0);
        return calculateSum(emoticons,users);
    }
    
    private int[] calculateSum(int[] emoticons,int[][] users){
        int max_member=0;
        int max_price=0;
        
        for(int j=0;j<emoticon_discount.size();j++){
            int[] discountList=emoticon_discount.get(j);
            int member=0;
            int price=0;
            for(int[] user:users){
                int rate=user[0];
                int money=user[1];
                int total=0;
                for(int i=0;i<emoticons.length;i++){
                    if(discountList[i]>=rate) total+=emoticons[i]-(emoticons[i]*discountList[i]/100);
                }
                if(total>=money) member++;
                else price+=total;
            }
            
            if((member==max_member&&price>max_price)||member>max_member){
                max_member=member;
                max_price=price;
            }
        }
        return new int[]{max_member,max_price};
    }
    private void dfs(int[] cur_discount,int level){
        if(level==cur_discount.length){
            emoticon_discount.add(cur_discount.clone());
            return;
        }else{
            for(int discount:discounts){
                cur_discount[level]=discount;
                dfs(cur_discount,level+1);
            }
        }
    }
}