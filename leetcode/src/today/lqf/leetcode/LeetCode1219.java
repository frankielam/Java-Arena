package today.lqf.leetcode;

public class LeetCode1219 {

    int max = 0;
    int[][] grid;

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                dfs(i, j, 0);
            }
        }
        return max;
    }

    private void dfs(int x, int y, int total) {
        total += grid[x][y];
        max = Math.max(max, total);
        int tmp = grid[x][y];
        grid[x][y] = 0;
        if (y + 1 < grid[0].length && grid[x][y + 1] > 0) {
            dfs(x, y + 1, total);
        }
        if (y - 1 >= 0 && grid[x][y - 1] > 0) {
            dfs(x, y - 1, total);
        }
        if (x + 1 < grid.length && grid[x + 1][y] > 0) {
            dfs(x + 1, y, total);
        }
        if (x - 1 >= 0 && grid[x - 1][y] > 0) {
            dfs(x - 1, y, total);
        }
        grid[x][y] = tmp;
    }

    public static void main(String[] args) {
        LeetCode1219 obj = new LeetCode1219();
        System.out.println(obj.getMaximumGold(new int[][] { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } }));
        System.out.println(obj.getMaximumGold(new int[][] { { 1, 0, 7 }, { 2, 0, 6 }, { 3, 4, 5 }, { 0, 3, 0 }, { 9, 0, 20 } }));
    }

}
