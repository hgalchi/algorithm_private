    package algorithm_private.인프런.ch02_Array;

    import java.util.Scanner;

    public class n10_봉우리 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[][] arr=new int[n][n];
            for (int i=0; i < n; i++) {
                for(int j=0; j < n; j++) {
                    arr[i][j]=sc.nextInt();
                }
            }
            int rt = 0, lt = 0, ut = 0, dt = 0,answer=0;
            //행
            for(int i=0; i < n; i++) {
                //열
                for(int j=0; j < n; j++) {
                    rt = j + 1;
                    lt = j - 1;
                    ut = i - 1;
                    dt = i + 1;
                    //상하좌우가 비교대상이고 현재 위치보다 값이 클경우
                    if(rt<n&&arr[i][j]<arr[i][rt]) continue;
                    if(lt>=0&&arr[i][j]<arr[i][lt]) continue;
                    if(ut>=0&&arr[i][j]<arr[ut][j]) continue;
                    if(dt<n&&arr[i][j]<arr[dt][j]) continue;
                    answer++;
                }
            }

            System.out.println(answer);

        }
    }
