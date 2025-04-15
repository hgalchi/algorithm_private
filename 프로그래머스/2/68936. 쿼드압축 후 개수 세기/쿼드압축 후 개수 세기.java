import java.util.*;

class Solution {
    static int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        answer = new int[2]; // 초기화 (다중 테스트 케이스 대응)
        compress(0, 0, arr, arr.length);
        return answer;
    }

    private void compress(int row, int col, int[][] arr, int size) {
        int first = arr[row][col];
        boolean isSame = true;

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != first) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        if (isSame) {
            answer[first]++;
        } else {
            int half = size / 2;
            compress(row, col, arr, half); // 왼쪽 위
            compress(row + half, col, arr, half); // 왼쪽 아래
            compress(row, col + half, arr, half); // 오른쪽 위
            compress(row + half, col + half, arr, half); // 오른쪽 아래
        }
    }
}
