package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeetCode745 {

    Map<String, List<Integer>> map;
    String[] words;

    public LeetCode745(String[] words) {
        this.words = words;
        for (int i = 0; i < words.length; i++) {
            String k = words[i].charAt(0) + "" + words[i].charAt(words[i].length() - 1);
            List<Integer> list = map.getOrDefault(k, new ArrayList<>());
            list.add(i);
            map.put(k, list);
        }
    }

    public int f(String pref, String suff) {
        String k = pref.charAt(0) + "" + suff.charAt(suff.length() - 1);
        if (map.containsKey(k)) {
            List<Integer> list = map.get(k);
            for (int i = list.size() - 1; i >= 0; i--) {
                int idx = list.get(i);
                String str = words[idx];
                if (str.startsWith(pref) && str.endsWith(suff)) {
                    return idx;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
