
import java.util.*;
class Solution {

   
    public boolean solution(String[] phone_book) {
        //phone_book을 해싱
        Set<String> map=new HashSet<>(List.of(phone_book));

        for(int i=0;i<phone_book.length;i++){
            for(int j=1;j<phone_book[i].length();j++){
                if(map.contains(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }
        return true;


    }
}