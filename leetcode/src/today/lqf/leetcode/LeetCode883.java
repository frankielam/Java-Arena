package today.lqf.leetcode;

public class LeetCode883 {

    public int projectionArea(int[][] grid) {
        int l = grid.length;
        int w = grid[0].length;
        int total = 0;
        for (int i = 0; i < l; i++) {
            int rMax = 0;
            int wMax = 0;
            for (int j = 0; j < w; j++) {
                if (grid[i][j] > 0) {
                    total++;
                }
                if (grid[i][j] > rMax) {
                    rMax = grid[i][j];
                }
                if (grid[j][i] > wMax) {
                    wMax = grid[j][i];
                }
            }
            total += rMax + wMax;
        }

        return total;
    }

    public static void main(String[] args) {
        LeetCode883 obj = new LeetCode883();
        System.out.println(obj.projectionArea(new int[][] { { 1, 2 }, { 3, 4 } }));

    }

}
