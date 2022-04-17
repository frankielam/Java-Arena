package today.lqf.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode819 {

    int max = 0;
    String mostStr = "";

    // paragraph 只包含字母、空格和下列标点符号!?',;.
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }
        Map<String, Integer> map = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        paragraph = paragraph.toLowerCase();
        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.charAt(i) >= 'a' && paragraph.charAt(i) <= 'z') {
                sb.append(paragraph.charAt(i));
            } else {
                if (!set.contains(sb.toString()) && sb.length() > 0) {
                    int cnt = map.getOrDefault(sb.toString(), 0);
                    map.put(sb.toString(), ++cnt);
                }
                sb = new StringBuffer();
            }
        }
        if (sb.length() > 0) {
            if (!set.contains(sb.toString())) {
                int cnt = map.getOrDefault(sb.toString(), 0);
                map.put(sb.toString(), ++cnt);
            }
        }

        map.forEach((k, v) -> {
            if (v > max) {
                max = v;
                mostStr = k;
            }
        });

        return mostStr;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LeetCode819 obj = new LeetCode819();
//        System.out.println(
//                obj.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] { "hit" }));
        System.out.println(obj.mostCommonWord("Bob. hIt, baLl", new String[] { "bob", "hit" }));

    }

}
