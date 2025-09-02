import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        Map<String,Integer> dir = new HashMap<>();
        int[] dx = {-1, 1, 0, 0}; // N, S, W, E
        int[] dy = {0, 0, -1, 1};
        dir.put("N",0);
        dir.put("S",1);
        dir.put("W",2);
        dir.put("E",3);

        char[][] map = new char[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            map[i] = park[i].toCharArray();
        }

        int row = 0, col = 0;
        // 시작 위치 찾기
        for (row = 0; row < map.length; row++) {
            for (col = 0; col < map[0].length; col++) {
                if (map[row][col] == 'S') break;
            }
            if (col < map[0].length && map[row][col] == 'S') break;
        }

        for (String route : routes) {
            String move_dir = route.split(" ")[0];
            int move_dis = Integer.parseInt(route.split(" ")[1]);

            int index = dir.get(move_dir);
            int nrow = row;
            int ncol = col;
            boolean canMove = true;

            for (int step = 0; step < move_dis; step++) {
                nrow += dx[index];
                ncol += dy[index];
                if (nrow < 0 || nrow >= map.length || ncol < 0 || ncol >= map[0].length || map[nrow][ncol] == 'X') {
                    canMove = false;
                    break;
                }
            }
            if (canMove) {
                row = nrow;
                col = ncol;
            }
        }
        return new int[]{row, col};
    }
}
