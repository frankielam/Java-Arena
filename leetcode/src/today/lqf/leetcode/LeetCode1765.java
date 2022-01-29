package today.lqf.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class LeetCode1765 {

    Queue<int[]> queue = new ArrayDeque<>();

    private void handle(int[][] height, int i, int j, int val) {
        if (i >= 0 && i < height.length && j >= 0 && j < height[0].length) {
            if (height[i][j] == -1) {
                height[i][j] = val + 1;
                queue.offer(new int[] { i, j });
            }
        }
    }

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    queue.offer(new int[] { i, j });
                } else {
                    height[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] idx = queue.poll();
            handle(height, idx[0], idx[1] + 1, height[idx[0]][idx[1]]);
            handle(height, idx[0] + 1, idx[1], height[idx[0]][idx[1]]);
            handle(height, idx[0], idx[1] - 1, height[idx[0]][idx[1]]);
            handle(height, idx[0] - 1, idx[1], height[idx[0]][idx[1]]);
        }

        return height;
    }

    public static void main(String[] args) {
        LeetCode1765 obj = new LeetCode1765();
//        int[][] arr = { { 0, 1 }, { 0, 0 } };
        int[][] arr = { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 0, 0} };
        int[][] rst = obj.highestPeak(arr);
        System.out.println(Arrays.deepToString(rst));
    }

}
