package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/
 */
public class LeetCode873 {

    int max = 0;

    public int lenLongestFibSubseq(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                int k = j + 1;
                int cnt = 2;
                dfs(arr, cnt, k, arr[j], arr[i] + arr[j]);
            }
        }
        return max;
    }

    private void dfs(int[] arr, int cnt, int idx, int pre, int target) {
        for (int i = idx; i < arr.length; i++) {
            if (arr[i] > target) {
                break;
            }
            if (arr[i] == target) {
                cnt++;
                if (cnt > max) {
                    max = cnt;
                }
                dfs(arr, cnt, idx + 1, target, pre + target);
                break;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode873 obj = new LeetCode873();
        System.out.println(obj.lenLongestFibSubseq(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
        System.out.println(obj.lenLongestFibSubseq(new int[] { 1, 3, 7, 11, 12, 14, 18 }));
        System.out.println(obj.lenLongestFibSubseq(new int[] { 2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50 }));
    }

}
