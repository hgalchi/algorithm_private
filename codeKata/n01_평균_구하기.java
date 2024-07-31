package algorithm_private.codeKata;

public class n01_평균_구하기 {
    public double solution(int[] arr) {
        double answer = 0;
        for(int x:arr){
            answer+=x;
        }
        answer/=arr.length;
        return answer;
    }
}
