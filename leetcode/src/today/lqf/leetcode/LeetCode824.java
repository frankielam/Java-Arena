package today.lqf.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode824 {

    public String toGoatLatin(String sentence) {
        char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
        Map<Integer, Integer> map = new HashMap<>();
        for (char c : vowels) {
            System.out.println(c + "\t" + (int) c);
            map.put((int) c, 1);
        }
        String[] words = sentence.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i].charAt(0) + "\t" + (int) words[i].charAt(0));
            if (!map.containsKey((int) words[i].charAt(0))) {   // 显式转换
                sb.append(words[i].substring(1));
                sb.append(words[i].charAt(0));
            } else {
                sb.append(words[i]);
            }
            int k = i;
            sb.append("ma");
            while (k-- >= 0) {
                sb.append("a");
            }
            if (i != words.length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode824 obj = new LeetCode824();
        System.out.println(obj.toGoatLatin("The quick brown fox jumped over the lazy dog"));

    }

}
