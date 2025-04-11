import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        
        List<String> list1=new ArrayList<>();
        List<String> list2=new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if (str1.equals(str2)) {
            return 65536;
        }



        char[] charList = str1.toCharArray();
        for (int i = 0; i < charList.length - 1; i++) {
            if (Character.isAlphabetic(charList[i]) && Character.isAlphabetic(charList[i + 1])) {
                list1.add(Character.toString(charList[i]) + Character.toString(charList[i + 1]));
            }

        }

        charList = str2.toCharArray();
        for (int i = 0; i < charList.length - 1; i++) {
            if (Character.isAlphabetic(charList[i]) && Character.isAlphabetic(charList[i + 1])) {
                list2.add(Character.toString(charList[i]) + Character.toString(charList[i + 1]));
            }
        }

        int inter=0;
        for (String s : list1) {
            if (list2.contains(s)) {
                list2.remove(s);
                inter++;
            }
        }

        int union = list1.size() + list2.size();

        return union==0?1:65536*inter/union;
    }
}