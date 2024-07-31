package algorithm_private.인프런.ch07_Recurcive_Tree_Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n08_송아지_찾기 {
    int[] ch;
    int[] dis = {1, -1, 5};

    public int bfs(int s,int e) {
        Queue<Integer> q = new LinkedList<>();
        int L = 0;
        q.add(s);
        ch = new int[10001];
        ch[s] = 1;

        while (!q.isEmpty()) {
            int size=q.size();
            for (int i = 0; i < size; i++) {
                int x = q.poll();
                    for(int j=0;j<dis.length;j++) {
                        int nx=x+dis[j];
                        if(nx==e) return L+1;
                        if(nx>0&&ch[nx]==0&&nx<=10000){
                            q.offer(x+dis[j]);
                            ch[nx] = 1;
                        }
                    }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(new n08_송아지_찾기().bfs(s, e));
    }
}

