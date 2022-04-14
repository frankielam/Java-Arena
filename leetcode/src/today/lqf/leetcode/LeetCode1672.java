package today.lqf.leetcode;

public class LeetCode1672 {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int total = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                total += accounts[i][j];
            }
            if (total > max)
                max = total;
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode1672 obj = new LeetCode1672();
        System.out.println(obj.maximumWealth(new int[][] { { 1, 2, 3 }, { 3, 2, 1 } }));

    }

}
