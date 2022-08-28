package today.lqf.leetcode;

import java.util.Arrays;

public class LeetCode2022082802 {

    /*
     * https://leetcode.cn/problems/longest-subsequence-with-limited-sum/
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] arr = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < queries.length; i++) {
            int cnt = 0;
            for (int j = 0, total = 0; j < nums.length; j++) {
                if (total + nums[j] > queries[i]) {
                    break;
                }
                total += nums[j];
                cnt++;
            }
            arr[i] = cnt;
        }

        return arr;
    }

    /*
     * https://leetcode.cn/problems/removing-stars-from-a-string/
     */
    public String removeStars(String s) {
        int cnt = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') {
                cnt++;
                continue;
            }

            if (cnt > 0) {
                cnt--;
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.reverse().toString();
    }

    /*
     * https://leetcode.cn/contest/weekly-contest-308/problems/minimum-amount-of-
     * time-to-collect-garbage/
     */
    public int garbageCollection(String[] garbage, int[] travel) {
        int len = garbage.length;
        int[] mArr = new int[len];
        int[] pArr = new int[len];
        int[] gArr = new int[len];
        for (int i = 0; i < len; i++) {
            String str = garbage[i];
            for (int j = 0; j < str.length(); j++) {
                char category = str.charAt(j);
                switch (category) {
                case 'M': {
                    mArr[i] += 1;
                    break;
                }
                case 'P': {
                    pArr[i] += 1;
                    break;
                }
                case 'G': {
                    gArr[i] += 1;
                    break;
                }
                }
            }
        }
        
        int m = 0, p = 0, g = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (mArr[i] > 0 || m > 0) {
                m += mArr[i];
                if (i > 0)
                    m += travel[i - 1];
            }
            if (pArr[i] > 0 || p > 0) {
                p += pArr[i];
                if (i > 0)
                    p += travel[i - 1];
            }
            if (gArr[i] > 0 || g > 0) {
                g += gArr[i];
                if (i > 0)
                    g += travel[i - 1];
            }
        }

        return m + p + g;
    }

    public static void main(String[] args) {
        LeetCode2022082802 obj = new LeetCode2022082802();
        System.out.println(obj.removeStars("leet**cod*e"));
        System.out.println(obj.removeStars("erase*****"));
        System.out.println(obj.removeStars("123****333"));
        System.out.println(obj.removeStars("123456*****"));
        System.out.println(Arrays.toString(obj.answerQueries(new int[] { 4, 5, 2, 1 }, new int[] { 3, 10, 21 })));
        System.out.println(Arrays.toString(obj.answerQueries(new int[] { 2, 3, 4, 5 }, new int[] { 2 })));
        System.out.println(obj.garbageCollection(new String[] { "MMM", "PGM", "GP" }, new int[] { 3, 10 }));
        System.out.println(obj.garbageCollection(new String[] { "G", "P", "GP", "GG" }, new int[] { 2, 4, 3 }));
    }

}
