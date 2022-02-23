package today.lqf.leetcode;

/**
 * 
 * https://leetcode-cn.com/problems/reverse-only-letters/
 *
 */
public class LeetCode917 {

    public String reverseOnlyLetters(String s) {
        int len = s.length();
        char[] arr = new char[len];
        for (int i = 0, j = len - 1; i <= j;) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (!(c1 >= 'a' && c1 <= 'z') && !(c1 >= 'A' && c1 <= 'Z')) {
                arr[i] = c1;
                i++;
                continue;
            }
            if (!(c2 >= 'a' && c2 <= 'z') && !(c2 >= 'A' && c2 <= 'Z')) {
                arr[j] = c2;
                j--;
                continue;
            }
            arr[i] = c2;
            arr[j] = c1;
            i++;
            j--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        LeetCode917 obj = new LeetCode917();
        System.out.println(obj.reverseOnlyLetters("ab-cd"));
        System.out.println(obj.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(obj.reverseOnlyLetters("Test1ng-Leet=code-Q!"));

    }

}
