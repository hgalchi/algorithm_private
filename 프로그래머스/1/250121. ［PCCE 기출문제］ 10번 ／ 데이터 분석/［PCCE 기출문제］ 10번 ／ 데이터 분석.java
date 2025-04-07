import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        String[] list=new String[]{"code","date","maximum","remain"};
        int index=-1;

        for(int i=0;i<4;i++){
            if(list[i].equals(ext)){
                index=i;
            }
        }

        List<int[]> data_list=new ArrayList<>();
        for(int[] cur:data){
            if(cur[index]<val_ext){
                data_list.add(cur);
            }
        }

        for(int i=0;i<4;i++){
            if(list[i].equals(sort_by)){
                index=i;
            }
        }
        int[][] answer=new int[data_list.size()][];
        int answer_index=0;
        while (!data_list.isEmpty()) {
            int min=987654321;
            int min_index=0;
            for (int i=0;i<data_list.size();i++){
                if(min>data_list.get(i)[index]){
                    min=data_list.get(i)[index];
                    min_index = i;
                }
            }
            answer[answer_index++] = data_list.get(min_index);
            data_list.remove(min_index);
        }
        return answer;
    }
}