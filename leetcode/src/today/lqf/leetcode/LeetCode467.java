package today.lqf.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 */
public class LeetCode467 {

    public int findSubstringInWraproundString2(String p) {
        int n = p.length();

        Set<String> set = new HashSet<>();
        char pre = p.charAt(0);
        set.add(String.valueOf(pre));
        int start = 0, end = 0;
        for (int i = 1; i < n; i++) {
            char c = p.charAt(i);
            set.add(String.valueOf(c));

            if ((int) (c - pre) == 1 || (pre == 'z' && c == 'a')) {
                end = i;
            } else {

                if (end >= start) {
                    String str = p.substring(start, end + 1);

                    for (int j = 2; j <= str.length(); j++) {
                        for (int k = 0; k <= str.length() - j; k++) {
                            String subStr = str.substring(k, k + j);
                            set.add(subStr);
                        }
                    }

                }
                start = i;
                end = i;
            }

            pre = c;
        }
        if (end > start) {
            String str = p.substring(start, end + 1);
            if (str.length() > 26 && set.size() <= 26) {
                return (1 + str.length()) * str.length() / 2 - str.length() + set.size();
            } else {
                for (int j = 2; j <= str.length(); j++) {
                    for (int k = 0; k <= str.length() - j; k++) {
                        String subStr = str.substring(k, k + j);
                        set.add(subStr);
                    }
                }
            }
        }
        return set.size();
    }

    public int findSubstringInWraproundString(String p) {
        int[] alphabet = new int[26];
        for (int i = 1, k = 1; i < p.length(); i++) {
            if ((p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                k++;
            } else {
                k = 1;
            }
            alphabet[p.charAt(i) - 'a'] = Math.max(alphabet[p.charAt(i) - 'a'], k);
        }

        return Arrays.stream(alphabet).sum();

    }

    public static void main(String[] args) {
        LeetCode467 obj = new LeetCode467();
        System.out.println(obj.findSubstringInWraproundString("zabkzax"));
        System.out.println(obj.findSubstringInWraproundString("aabb"));
        System.out.println(obj.findSubstringInWraproundString(
                "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));

    }

}
