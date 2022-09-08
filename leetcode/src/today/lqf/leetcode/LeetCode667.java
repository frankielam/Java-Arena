package today.lqf.leetcode;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/beautiful-arrangement-ii/
 */
public class LeetCode667 {

    public int[] constructArray(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0, j = k, r = n, l = 1; i < n; i++) {
            if (j <= 1) {
                if (k % 2 != 0) {
                    arr[i] = r;
                    r--;
                } else {
                    arr[i] = l;
                    l++;
                }
            } else {
                if (i % 2 == 0) {
                    arr[i] = r;
                    r--;
                } else {
                    arr[i] = l;
                    l++;
                }

            }
            j--;
        }
        return arr;
    }

    public static void main(String[] args) {
        LeetCode667 obj = new LeetCode667();
        System.out.println(Arrays.toString(obj.constructArray(3, 1)));
        System.out.println(Arrays.toString(obj.constructArray(3, 2)));
        System.out.println(Arrays.toString(obj.constructArray(10, 9)));
        System.out.println(Arrays.toString(obj.constructArray(10, 8)));
    }

}
