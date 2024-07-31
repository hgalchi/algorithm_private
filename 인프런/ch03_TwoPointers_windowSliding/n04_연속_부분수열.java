    package algorithm_private.인프런.ch03_TwoPointers_windowSliding;

    import java.util.Scanner;

    public class n04_연속_부분수열 {

        public int solution(int m,int[] arr) {
            int answer = 0;
            int x = 0,y=0, sum = 0;
            while (x < arr.length) {
                if(sum==m){
                    answer++;
                    sum+=arr[x++]-arr[y++];
                }else if(sum>m) sum -= arr[y++];
                 else sum += arr[x++];
            }

            return answer;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr=new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]=sc.nextInt();
            }
            n04_연속_부분수열 t = new n04_연속_부분수열();
            System.out.println(t.solution(m,arr));
        }

    }
