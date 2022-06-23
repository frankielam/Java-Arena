package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
 */
public class LeetCode30 {

    public List<Integer> findSubstring(String s, String[] words) {
        int len = s.length();
        int wordLen = words[0].length();
        int cnt = words.length;
        int subLen = wordLen * cnt;
        List<Integer> list = new ArrayList<>();
        if (subLen > len) {
            return list;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - subLen; i++) {
            Map<String, Integer> dupMap = new HashMap<>();
            boolean f = true;
            for (int j = i; j < i + subLen; j = j + wordLen) {
                String w = s.substring(j, j + wordLen);
                if (!map.containsKey(w) || dupMap.getOrDefault(w, 0).intValue() == map.get(w).intValue()) {
                    f = false;
                    break;
                }
                dupMap.put(w, dupMap.getOrDefault(w, 0) + 1);
            }
            if (f) {
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        LeetCode30 obj = new LeetCode30();
        System.out.println(obj.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));
        System.out.println(
                obj.findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" }));
    }

}
