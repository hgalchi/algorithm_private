import java.util.*;
class Solution {
    public int solution(int N, int number) {
       List<Set<Integer>> box=new ArrayList<>();
        for(int i=0;i<=8;i++){
            box.add(new HashSet<Integer>());
        }
        //n을 한번 사용했을 경우
        box.get(1).add(N);
        
        //n을 i번 사용했을 때 나오는 값의 경우의 수를 연산
        for(int i=2;i<=8;i++){
            for(int j=1;j<i;j++){
                for(int num1:box.get(j)){
                    for(int num2:box.get(i-j)){
                        box.get(i).add(num1+num2);
                        box.get(i).add(num1-num2);
                        box.get(i).add(num1*num2);
                        if(num1!=0&&num2!=0){
                            box.get(i).add(num1/num2);
                        }
                    }
                }
            }
            box.get(i).add(Integer.parseInt((""+N).repeat(i)));
        }
        
        for(int i=1;i<=8;i++){
            if(box.get(i).contains(number)){
                return i;
            }
        }return -1;
    }
}