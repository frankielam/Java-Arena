package today.lqf.leetcode;

import java.util.Arrays;

/**
 * 
 * https://leetcode-cn.com/problems/plates-between-candles/
 *
 */
public class LeetCode2055 {

    /**
     * 看了答案才行出来的版本 
     */
    public int[] platesBetweenCandles(String s, int[][] queries) {

        int len = s.length();
        int[] preCounter = new int[len];
        for (int i = 0, c = 0; i < len; i++) {
            if (s.charAt(i) == '*') {
                c++;
            }
            preCounter[i] = c;
        }
        System.out.println(Arrays.toString(preCounter));

        int[] prefixIdx = new int[len];
        for (int i = len - 1, idx = -1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                idx = i;
            }
            prefixIdx[i] = idx;
        }

        System.out.println(Arrays.toString(prefixIdx));

        int[] suffixIdx = new int[len];
        for (int i = 0, idx = -1; i < len; i++) {
            if (s.charAt(i) == '|') {
                idx = i;
            }
            suffixIdx[i] = idx;
        }

        System.out.println(Arrays.toString(suffixIdx));

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = prefixIdx[query[0]];
            int y = suffixIdx[query[1]];
            if (x == -1 || y  == -1 || x >= y)  {
                result[i] = 0;
            } else {
                result[i] = preCounter[y] - preCounter[x];
            }
            
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode2055 obj = new LeetCode2055();

        System.out.println(Arrays.toString(obj.platesBetweenCandles("**|**|***|", new int[][] { { 2, 5 }, { 5, 9 } })));
        System.out.println(Arrays.toString(obj.platesBetweenCandles("***|**|*****|**||**|*",
                new int[][] { { 1, 17 }, { 4, 5 }, { 14, 17 }, { 5, 11 }, { 15, 16 } })));

    }

}
