package today.lqf.leetcode;

public class LeetCode1995 {

    public int countQuadruplets(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int x = 0; x < nums.length; x++) {
                        if (nums[i] + nums[j] + nums[k] == nums[x]) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode1995 obj = new LeetCode1995();

        int[] array = { 28, 8, 49, 85, 37, 90, 20, 8 };
        long s = System.currentTimeMillis();
        int rst = obj.countQuadruplets(array);
        long e = System.currentTimeMillis();

        System.out.println("return value is " + rst);
        System.out.println("using time (" + (e - s) + "ms)");
    }

}
