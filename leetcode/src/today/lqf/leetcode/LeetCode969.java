package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode969 {

    int[] arrays;

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        arrays = arr;
        int len = arrays.length;
        if (len <= 1)
            return list;
        int j = len - 1;
        while (true) {
            boolean f = false;
            for (int i = 0; i < j; i++) {
                if (arrays[i] > arrays[j]) {
                    int idx = i == 0 ? j : i;
                    reverse(idx);
                    list.add(idx + 1);
                    break;
                }
                if (i == j - 1) {
                    f = true;
                }
            }
            if (f)
                j--;
            if (j == 0)
                break;

        }

        return list;
    }

    private void reverse(int n) {
        for (int i = 0, j = n; i < j; i++, j--) {
            int tmp = arrays[i];
            arrays[i] = arrays[j];
            arrays[j] = tmp;
        }
//        System.out.println(Arrays.toString(arrays));
    }

    public static void main(String[] args) {
        LeetCode969 obj = new LeetCode969();
        System.out.println(obj.pancakeSort(new int[] { 3, 2, 4, 1 }));
        System.out.println(obj.pancakeSort(new int[] { 2, 3, 1 }));
        System.out.println(obj.pancakeSort(new int[] { 1, 2, 3}));
        System.out.println(obj.pancakeSort(new int[] { 1, 2, 4, 3 }));
    }

}
