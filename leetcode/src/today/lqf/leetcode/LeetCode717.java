package today.lqf.leetcode;

/**
 * https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 *
 */
public class LeetCode717 {

    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        for (int i = 0; i < len;) {
            if (bits[i] == 1) {
                i += 2;
                if (i == len)
                    return false;
            } else {
                i++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LeetCode717 obj = new LeetCode717();
        System.out.println(obj.isOneBitCharacter(new int[] { 1, 0, 0 }));

        System.out.println(obj.isOneBitCharacter(new int[] { 1, 1, 1, 0 }));

    }

}
