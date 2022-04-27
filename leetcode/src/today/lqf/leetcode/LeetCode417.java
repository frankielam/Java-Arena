package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 */
public class LeetCode417 {

    int[][] a;
    Set<String> set;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                set = new HashSet<>();
                a[i][j] = flow(heights, i, j);
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 3) {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(i);
                    sub.add(j);
                    list.add(sub);
                }
            }
        }
        return list;
    }

    public int flow(int[][] heights, int i, int j) {
        if (a[i][j] != 0) {
            return a[i][j];
        }

        if ((i == 0 && j == heights[0].length - 1) || (j == 0 && i == heights.length - 1)) {
            return 1 | 2;
        }

        int max = 0;
        if (i == 0 || j == 0) {
            max |= 1;
        }
        if (i == heights.length - 1 || j == heights[0].length - 1) {
            max |= 2;
        }
        set.add(i + "," + j);
        if (j < heights[0].length - 1 && heights[i][j] >= heights[i][j + 1] && !set.contains(i + "," + (j + 1))) {
            max |= flow(heights, i, j + 1);
        }
        if (i < heights.length - 1 && heights[i][j] >= heights[i + 1][j] && !set.contains((i + 1) + "," + j)) {
            max |= flow(heights, i + 1, j);
        }
        if (j > 0 && heights[i][j] >= heights[i][j - 1] && !set.contains(i + "," + (j - 1))) {
            max |= flow(heights, i, j - 1);
        }
        if (i > 0 && heights[i][j] >= heights[i - 1][j] && !set.contains((i - 1) + "," + j)) {
            max |= flow(heights, i - 1, j);
        }

        return max;

    }

    public static void main(String[] args) {
        LeetCode417 obj = new LeetCode417();
        System.out.println(obj.pacificAtlantic(new int[][] { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } }));
        System.out.println(obj.pacificAtlantic(new int[][] { { 13 }, { 4 }, { 19 }, { 10 }, { 1 }, { 11 }, { 5 },
                { 17 }, { 3 }, { 10 }, { 1 }, { 0 }, { 1 }, { 4 }, { 1 }, { 3 }, { 6 }, { 13 }, { 2 }, { 16 }, { 7 },
                { 6 }, { 3 }, { 1 }, { 9 }, { 9 }, { 13 }, { 10 }, { 9 }, { 10 }, { 6 }, { 2 }, { 11 }, { 17 }, { 13 },
                { 0 }, { 19 }, { 7 }, { 13 }, { 3 }, { 9 }, { 2 } }));

    }

}
