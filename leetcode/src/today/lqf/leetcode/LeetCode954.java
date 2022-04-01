package today.lqf.leetcode;

import java.util.Arrays;

public class LeetCode954 {

    public boolean canReorderDoubled(int[] arr) {

        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        int MIN = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == MIN) {
                continue;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == MIN) {
                    continue;
                }
                int m, n;
                if (arr[j] < 0) {
                    m = 0 - arr[j];
                    n = 0 - arr[i];
                } else {
                    m = arr[i];
                    n = arr[j];
                }

                if (m * 2 == n) {
                    arr[j] = MIN;
                    cnt++;
                    break;
                } else if (m * 2 < n) {
                    return false;
                }
            }
        }

        return cnt == arr.length / 2 ? true : false;
    }

    public static void main(String[] args) {
        LeetCode954 obj = new LeetCode954();
        System.out.println(obj.canReorderDoubled(new int[] { 3, 1, 3, 6 }));
        System.out.println(obj.canReorderDoubled(new int[] { 2, 1, 2, 6 }));

        System.out.println(obj.canReorderDoubled(new int[] { 4, -2, 2, -4 }));

    }

}
