package today.lqf.leetcode;

public class LeetCode565 {

    public int arrayNesting(int[] nums) {
        int[] arr = new int[nums.length];
        int cnt = 0, key = 0, time = 0;
        for (int num : nums) {
            key = num;
            time = 0;
            while (arr[key] == 0) {
                arr[key] = 1;
                time++;
                key = nums[key];
            }
            if (time > cnt)
                cnt = time;
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode565 obj = new LeetCode565();
        System.out.println(obj.arrayNesting(new int[] { 0, 1, 2 }));
    }

}
