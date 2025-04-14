import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (f1, f2) -> {
            String head1 = getHead(f1);
            String head2 = getHead(f2);
            int cmp = head1.compareToIgnoreCase(head2);

            if (cmp == 0) {
                int num1 = getNumber(f1);
                int num2 = getNumber(f2);
                return Integer.compare(num1, num2);
            }
            return cmp;
        });
        return files;
    }

    private String getHead(String file) {
        int i = 0;
        while (i < file.length() && !Character.isDigit(file.charAt(i))) i++;
        return file.substring(0, i);
    }

    private int getNumber(String file) {
        int i = 0;
        while (i < file.length() && !Character.isDigit(file.charAt(i))) i++;
        int j = i;
        while (j < file.length() && Character.isDigit(file.charAt(j)) && j - i < 5) j++;
        return Integer.parseInt(file.substring(i, j));
    }
}
