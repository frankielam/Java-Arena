package today.lqf.leetcode;

public class LeetCode334 {

    public boolean increasingTriplet2(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;

        int first = nums[0], second = Integer.MAX_VALUE, current;
        for (int i = 1; i < len; i++) {
            current = nums[i];
            if (current > second) {
                return true;
            } else if (current > first) {
                second = current;
            } else {
                first = current;
            }
        }        
        return false;
    }
    
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        
        int[] minArr = new int[len];
        int[] maxArr = new int[len];
        minArr[0] = nums[0];
        for (int i = 1; i < len - 1; i++) {
            minArr[i] = Integer.min(nums[i], minArr[i-1]);
        }
        
        maxArr[len-1] = nums[len-1];
        for (int i = len - 2; i > 0; i--) {
            maxArr[i] = Integer.max(nums[i], maxArr[i+1]);
        }

        for (int i = 1; i < len - 1; i++) {
            if (minArr[i] < nums[i]  && nums[i] < maxArr[i]) {
                return true;
            }
        }
        
        return false;
    }    
    public static void main(String[] args) {
        LeetCode334 obj = new LeetCode334();
        int[] nums = {20,100,10,12,5,13};
//        boolean rst = obj.increasingTriplet2(nums);
        boolean rst = obj.increasingTriplet(nums);
        System.out.println(rst);
        

    }

}
