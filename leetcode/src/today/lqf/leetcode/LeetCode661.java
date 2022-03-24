package today.lqf.leetcode;

import java.util.Arrays;

public class LeetCode661 {

    public int[][] imageSmoother(int[][] img) {
        int row = img.length;
        int col = img[0].length;
        int[][] pos = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 0 }, { 0, 1 }, { 1, -1 },
                { 1, 0 }, { 1, 1 } };

        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int sum = 0, cnt = 0;
                for (int k = 0; k < pos.length; k++) {
                    if (i + pos[k][0] >= 0 && i + pos[k][0] < row && j + pos[k][1] >= 0 && j + pos[k][1] < col) {
                        sum += img[i + pos[k][0]][j + pos[k][1]];
                        cnt++;
                    }
                }
                result[i][j] = sum / cnt;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode661 obj = new LeetCode661();

        System.out
                .println(Arrays.deepToString(obj.imageSmoother(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } })));
        System.out.println(Arrays.deepToString(
                obj.imageSmoother(new int[][] { { 100, 200, 100 }, { 200, 50, 200 }, { 100, 200, 100 } })));

    }

}
