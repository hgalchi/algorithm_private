package algorithm_private.codeKata;

class n09_정수_제곱근_판별 {
    public long solution(long n) {
        double value=Math.sqrt(n);
        if(value==(int)Math.sqrt(n)){
            return (long)Math.pow(value+1,2);
        }else return -1;
    }
}
