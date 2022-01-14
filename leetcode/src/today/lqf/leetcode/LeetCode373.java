package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0)
            return rst;

        int len1 = nums1.length, len2 = nums2.length;
        int m1 = len1, m2 = len2;
        if (len1 > k && len2 > k) {
            m1 = k;
            m2 = k;
        } else if (len1 > k || len2 > k) {
            if (len1 > k) {
                m1 = k;
            } else {
                m2 = k;
            }
        }
        int[] valueArr = new int[k > len1 * len2 ? len1 * len2 : k];
        int[][] arr = new int[m1][m2];
        for (int i = 0, idx = 0; i < m1; i++) {
            for (int j = 0; j < m2; j++) {
                arr[i][j] = nums1[i] + nums2[j];
                if (idx == k) {
                    if (valueArr[k - 1] > arr[i][j]) {
                        valueArr[k - 1] = arr[i][j];
                        Arrays.sort(valueArr);
                        System.out.println(Arrays.toString(valueArr));
                    }
                } else {
                    valueArr[idx++] = arr[i][j];
                    if (idx == k) {
                        Arrays.sort(valueArr);
                        System.out.println(Arrays.toString(valueArr));

                    }
                }
            }
        }
        System.out.println(Arrays.toString(valueArr));
        int max = valueArr[valueArr.length - 1];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < m2; j++) {
                if (arr[i][j] <= max) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums1[i]);
                    item.add(nums2[j]);
                    rst.add(item);
                }
            }
        }
        Collections.sort(rst, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0).intValue() == o2.get(0).intValue()) {
                    return o1.get(1).intValue() - o2.get(1).intValue();
                }
                return o1.get(0).intValue() - o2.get(0).intValue();
            }
        });
        return rst.subList(0, k);
    }

    public static void main(String[] args) {
        LeetCode373 obj = new LeetCode373();
        int[] nums1 = { 0, 0, 0, 0, 0 };
        int[] nums2 = { -3, 22, 35, 56, 76 };
        List list = obj.kSmallestPairs(nums1, nums2, 22);
        System.out.println(Arrays.toString(list.toArray()));

    }

}
