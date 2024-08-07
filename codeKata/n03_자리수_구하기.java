package algorithm_private.codeKata;

public class n03_자리수_구하기 {
    int solution(int n) {
        int answer = 0;

        while(n/10!=0){
            answer+=n%10;
            n/=10;
        }
        return answer+n;
    }
}
