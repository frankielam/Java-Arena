package today.lqf.leetcode;

import java.util.Arrays;

public class LeetCode1020 {

    int[][] arr;

    public int numEnclaves(int[][] grid) {
        if (grid.length == 1 || grid[0].length == 1)
            return 0;

        arr = grid;

        for (int i = 0; i < grid.length; i++) {
            dfs(i, 0);
            dfs(i, grid[0].length - 1);
        }
        for (int i = 1; i < grid[0].length - 1; i++) {
            dfs(0, i);
            dfs(grid.length - 1, i);
        }

        int cnt = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[0].length - 1; j++) {
                if (arr[i][j] == 1)
                    cnt++;
            }
        }
        return cnt;
    }

    private void dfs(int x, int y) {
        if (arr[x][y] == 1) {
            arr[x][y] = 2;
            if (y + 1 < arr[0].length)
                dfs(x, y + 1);
            if (x + 1 < arr.length)
                dfs(x + 1, y);
            if (y - 1 >= 0)
                dfs(x, y - 1);
            if (x - 1 >= 0)
                dfs(x - 1, y);
        }
    }

    public static void main(String[] args) {
        LeetCode1020 obj = new LeetCode1020();
        System.out.println(
                obj.numEnclaves(new int[][] { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } }));
        System.out.println(
                obj.numEnclaves(new int[][] { { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } }));

    }

}
