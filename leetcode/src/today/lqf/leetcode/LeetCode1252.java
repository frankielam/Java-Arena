package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/
 */
public class LeetCode1252 {

    public int oddCells(int m, int n, int[][] indices) {
        int[] arrM = new int[m];
        int[] arrN = new int[n];

        for (int[] in : indices) {
            arrM[in[0]]++;
            arrN[in[1]]++;
        }
        int cntM = 0, cntN = 0;
        for (int i = 0; i < m; i++) {
            if (arrM[i] % 2 == 1) {
                cntM++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arrN[i] % 2 == 1) {
                cntN++;
            }
        }
        return cntM * (n - cntN) + cntN * (m - cntM);
    }

    public static void main(String[] args) {
        LeetCode1252 obj = new LeetCode1252();
        System.out.println(obj.oddCells(3, 2, new int[][] {{0,1}, {1,1}}));

    }

}
