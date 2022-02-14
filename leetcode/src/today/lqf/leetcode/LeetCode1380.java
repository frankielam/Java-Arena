package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1380 {

    // https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {

            int min = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < matrix[i][min]) {
                    min = j;
                }
            }
            boolean f = true;
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][min] > matrix[i][min]) {
                    f = false;
                    break;
                }
            }
            if (f) {
                list.add(matrix[i][min]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        LeetCode1380 obj = new LeetCode1380();
        System.out.println(obj.luckyNumbers(new int[][] { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } }));

    }

}
