import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long low = 0;
        long high = (long) n * times[times.length - 1];
        
        while (low <= high) {
            long mid = (low + high) / 2;
            long total = 0;
            
            for (int time : times) {
                total += mid / time;
            }
            
            if (total >= n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}