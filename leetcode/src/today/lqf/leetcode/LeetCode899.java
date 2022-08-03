package today.lqf.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/orderly-queue/
 */
public class LeetCode899 {

    public String orderlyQueue(String s, int k) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        if (k > 1) {
            return new String(arr);
        } else {
            String minStr = s;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) <= minStr.charAt(0)) {
                    for (int j = 0; j < minStr.length(); j++) {
                        int idx = (i + j) % minStr.length();
                        if (s.charAt(idx) != minStr.charAt(j)) {
                            if (s.charAt(idx) < minStr.charAt(j)) {
                                minStr = s.substring(i) + s.substring(0, i);
                            }
                            break;
                        }
                    }
                }
            }
            return minStr;
        }

    }

    public static void main(String[] args) {
        LeetCode899 obj = new LeetCode899();
        System.out.println(obj.orderlyQueue("cba", 1));
        System.out.println(obj.orderlyQueue("baaca", 3));
        System.out.println(obj.orderlyQueue("aaazyxcbazzz", 1));
    }
}
