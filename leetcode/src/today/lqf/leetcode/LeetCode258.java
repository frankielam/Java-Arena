package today.lqf.leetcode;

/**
 * 
 * https://leetcode-cn.com/problems/add-digits/
 *
 */
public class LeetCode258 {

    public int addDigits(int num) {
        
        while (num >= 10) {
            int n = num;
            int t = 0;
            while (n >= 10) {
                t += n % 10;
                n = n / 10;
            }
            num = t + n;
        }
        
        return num;
    }
    
    public static void main(String[] args) {
        LeetCode258 obj = new LeetCode258();
        System.out.println(obj.addDigits(992));

    }

}
