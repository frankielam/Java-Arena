package today.lqf.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 * https://leetcode.cn/problems/longest-uncommon-subsequence-ii/
 */
public class LeetCode522 {

    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> {
            if (b.length() == a.length()) {
                return Arrays.compare(a.toCharArray(), b.toCharArray());
            }
            return b.length() - a.length();
        });
        
        Set<String> set = new HashSet<>();
//        set.add(strs[0]);
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if ((i > 0 && strs[i - 1].equals(str)) || (i + 1 < strs.length && str.equals(strs[i + 1]))) {
                set.add(str);
                continue;
            }
            boolean f = true;
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String curStr = it.next();                
//                for (int j = 0, k = 0; j < str.length(); j++) {
//                    for (; k < curStr.length(); k++) {
//                        if (str.charAt(j)  == curStr.charAt(k)) {
//                            k++;
//                            if (j == str.length() - 1) {
//                                f = false;
//                            }
//                            break;
//                        }
//                    }
//                }
                int j = 0, k = 0;
                while (j < str.length() && k < curStr.length()) {
                    if (str.charAt(j) == curStr.charAt(k)) {
                        j++;
                        if (j == str.length()) {
                            f = false;
                        }
                    }
                    k++;
                }
            }
            if (f) {
                return str.length();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode522 obj = new LeetCode522();
        System.out.println(obj.findLUSlength(new String[] { "aaa", "aaa", "a" }));
        System.out.println(obj.findLUSlength(new String[] { "aabbcc", "aabbcc","bc","bcc","aabbccc" }));
    }

}
