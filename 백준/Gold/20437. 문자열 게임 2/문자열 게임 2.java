
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            Map<String, List<Integer>> map = new HashMap<>();
            String[] w = br.readLine().split("");
            int k = Integer.parseInt(br.readLine());


            for (int i = 0; i < w.length; i++) {
                List<Integer> list=map.getOrDefault(w[i], new ArrayList<>());
                list.add(i);
                map.put(w[i], list);
            }

            int max = 0,min=w.length;
            for (List<Integer> pos : map.values()) {
                if (pos.size() >= k) {
                    for (int i = k - 1; i < pos.size(); i++) {
                        int lt = pos.get(i - k + 1);
                        int rt = pos.get(i);
                        max = Math.max(max, rt - lt + 1);
                        min = Math.min(min, rt - lt + 1);
                    }
                }
            }
            System.out.println(max == 0 &&min==w.length? -1 : min+" "+max );

        }

    }
}
