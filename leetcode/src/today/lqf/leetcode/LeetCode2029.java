package today.lqf.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode2029 {

    public boolean stoneGameIX(int[] stones) {
        int len = stones.length;
        if (len == 1)
            return false;

        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < len; i++) {
            if (stones[i] % 3 == 0) {
                cnt0++;
            } else if (stones[i] % 3 == 1) {
                cnt1++;
            } else {
                cnt2++;
            }
        }
        System.out.println(cnt0);
        System.out.println(cnt1);
        System.out.println(cnt2);
        if (cnt0 % 2 == 0) {
            return cnt1 >= 1 && cnt2 >= 1;
        }
        System.out.println(Math.abs(cnt1 - cnt2));
        return Math.abs(cnt1 - cnt2) > 2;
    }

    public static void main(String[] args) {
        LeetCode2029 obj = new LeetCode2029();
        int[] arr = { 1, 1, 3};
        // 1,1, 2,1, 2,1,
        // 2,2, 1,2, 1,0

        boolean rst = obj.stoneGameIX(arr);
        System.out.println(rst);
    }

}
