import java.util.*;
class Solution { 
    public int solution(int[] mats, String[][] park) {
        int answer = -1;

        for (int mat : mats) {
            answer = Math.max(answer, linearSearch(mat, park));
        }
        return answer;
    }

    private int linearSearch(int mat, String[][] park) {
        for (int i = 0; i < park.length - mat + 1; i++) {
            for (int j = 0; j < park[i].length - mat + 1; j++) {
                if (linearSearch(new int[] {i, j}, mat, park)) {
                    return mat;
                }
            }
        }
        return -1;
    }

    private boolean linearSearch(int[] coordinator, int mat, String[][] park) {
        for (int i = coordinator[0]; i < coordinator[0] + mat; i++) {
            for (int j = coordinator[1]; j < coordinator[1] + mat; j++) {
                if (!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
}