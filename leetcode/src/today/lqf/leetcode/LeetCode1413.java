package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
public class LeetCode1413 {

    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum < min) {
                min = sum;
            }
        }
        if (min > 0)
            return 1;
        return 1 - min;
    }

    public static void main(String[] args) {
        LeetCode1413 obj = new LeetCode1413();
        System.out.println(obj.minStartValue(new int[] { -3, 2, -3, 4, 2 }));
        System.out.println(obj.minStartValue(new int[] { 1, 2 }));
        System.out.println(obj.minStartValue(new int[] { 1, -2, -3 }));

    }

}
