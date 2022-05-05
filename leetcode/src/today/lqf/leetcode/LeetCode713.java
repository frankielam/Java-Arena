package today.lqf.leetcode;

public class LeetCode713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int total = 1;
            for (int j = i; j < nums.length; j++) {
                total *= nums[j];
                if (total < k) {
                    cnt++;
                } else {
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode713 obj = new LeetCode713();
        System.out.println(obj.numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
        System.out.println(obj.numSubarrayProductLessThanK(new int[] { 1, 2, 3 }, 0));
    }

}
