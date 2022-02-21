package today.lqf.leetcode;

/**
 * https://leetcode-cn.com/problems/push-dominoes/
 */
public class LeetCode838 {

    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        boolean f;
        while (true) {
            f = false;
            int pre = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == '.') {
                    int sum = 0;
                    if (i - 1 >= 0 && arr[i - 1] == 'R' && pre != i - 1) {
                        sum += -1;
                    }
                    if (i + 1 < arr.length && arr[i + 1] == 'L') {
                        sum += 1;
                    }
                    if (sum != 0) {
                        arr[i] = sum == -1 ? 'R' : 'L';
                        f = true;
                        pre = i;
                    }
                }
            }
            if (!f) {
                break;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        LeetCode838 obj = new LeetCode838();
        System.out.println(obj.pushDominoes("RR.L"));
        System.out.println(obj.pushDominoes(".L.R...LR..L..")); // "LL.RR.LLRRLL.." 

    }

}
