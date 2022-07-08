package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/
 */
public class LeetCode1217 {

    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int pos : position) {
            if (pos % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }

    public static void main(String[] args) {
        LeetCode1217 obj = new LeetCode1217();
        System.out.println(obj.minCostToMoveChips(new int[] {1, 2, 3}));
        System.out.println(obj.minCostToMoveChips(new int[] {2, 2, 2, 3, 3}));
    }

}
