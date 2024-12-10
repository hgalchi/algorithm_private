import java.util.*;
class Solution {
    public int solution(String s) {
        StringBuilder sb=new StringBuilder();
        
        int j=0;
        for(int i=1;i<s.length()+1;i++)
        {
            //숫자인 경우 - '3'<'a'
            if(s.charAt(j)<'a'){
                sb.append(s.charAt(j));
                j++;
                continue;
            }else{
                //j부터 문자를 탐색
            if(i-j>2){
                String str=s.substring(j,i);
                switch(str){
                    case "zero":
                        sb.append("0");
                        j=i;
                        break;
                    case "one":
                        sb.append("1");
                        j=i;
                        break;
                    case "two":
                        sb.append("2");
                        j=i;
                        break;
                    case "three":
                        sb.append("3");
                        j=i;
                        break;
                    case "four":
                        sb.append("4");
                        j=i;
                        break;
                    case "five":
                        sb.append("5");
                        j=i;
                        break;
                    case "six":
                        sb.append("6");
                        j=i;
                        break;
                    case "seven":
                        sb.append("7");
                        j=i;
                        break;
                    case "eight":
                        sb.append("8");
                        j=i;
                        break;
                    case "nine":
                        j=i;
                        sb.append("9");
                        break;
                        
                }
            }
            
            }
           
        }
        return Integer.parseInt(sb.toString()); 
    
    }
}