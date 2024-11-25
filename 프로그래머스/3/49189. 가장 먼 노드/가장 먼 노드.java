import java.util.*;
class Solution {

    class Node{
        int node;
        int level;

        public Node(int node, int level){
            this.node=node;
            this.level=level;
        }
    }
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<edge.length;i++){
            graph.get(edge[i][0]).add(edge[i][1]);
                        graph.get(edge[i][1]).add(edge[i][0]);

        }

        Queue<Node> q=new LinkedList<>();
        boolean[] visited=new boolean[n+1];
        int[] list=new int[n+1];
        q.offer(new Node(1,0));
        visited[1]=true;
        while(!q.isEmpty()){
            Node node=q.poll();
            for(int i:graph.get(node.node)){
                if (!visited[i]) {
                visited[i]=true;
                q.offer(new Node(i,node.level+1));
                list[node.level]++;
                }
            }
        }
        for(int i=list.length-1;i>=0;i--){
            if(list[i]!=0){
                return list[i];
            }
        }return 0;
    }
}