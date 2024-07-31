package algorithm_private.인프런.ch07_Recurcive_Tree_Graph;

public class n01_재귀함수 {
    static int[] fibo;
    public int solution(int n) {
        if (n == 1 || n == 2) {
            System.out.println(1);
            return 1;
        } else {
            int x = solution(n - 1);
            int y = solution(n - 2);
            System.out.println(x+y);
            return x + y;
        }
    }

    public static void main(String[] args) {
        new n01_재귀함수().solution(5);
    }
}
