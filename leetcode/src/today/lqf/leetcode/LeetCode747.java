package today.lqf.leetcode;

public class LeetCode747 {

    public int dominantIndex(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return 0;
        int idx = 0;
        int min = 0, max = nums[idx];
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            if (num >= max) {
                min = max;
                max = num;
                idx = i;
            } else {
                min = Integer.max(min, num);
            }
        }
        if (max >= min * 2)
            return idx;
        return -1;
    }

    public static void main(String[] args) {
        LeetCode747 obj = new LeetCode747();
        int[] nums = { 3, 6, 1, 0 };
        int rst = obj.dominantIndex(nums);
        System.out.println(rst);

    }

}
