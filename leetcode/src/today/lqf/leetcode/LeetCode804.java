package today.lqf.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode804 {

    public int uniqueMorseRepresentations(String[] words) {
        String[] code = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < words[i].length(); j++) {
                int k = words[i].charAt(j) - 'a';
                sb.append(code[k]);
            }
            set.add(sb.toString());
        }

        return set.size();
    }

    public static void main(String[] arg) {
        LeetCode804 obj = new LeetCode804();
        System.out.println(obj.uniqueMorseRepresentations(new String[] { "gin", "zen", "gig", "msg" }));
    }
}
