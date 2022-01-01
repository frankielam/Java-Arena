package today.lqf.leetcode;

import java.util.Arrays;

public class LeetCode2022 {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) return new int[][] {};
        
        int[][] arr = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            arr[i/n][i%n] = original[i];
        }        
        return arr;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LeetCode2022 obj = new LeetCode2022();
        int[][] arr = obj.construct2DArray(new int[]{1, 2}, 1, 2);
        System.out.println(Arrays.toString(arr));

    }

}
