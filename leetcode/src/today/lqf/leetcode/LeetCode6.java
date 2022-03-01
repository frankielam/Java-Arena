package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 */
public class LeetCode6 {

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        
        int len = s.length();
        List<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuffer());
        }

        for (int i = 0, r = 0; i < len;) {
            if (r == 0) {
                for (; r < numRows && i < len; r++, i++) {
                    list.get(r).append(s.charAt(i));
                }
            } else {
                r = r - 2;
                for (; r > 0 && i < len; r--, i++) {
                    list.get(r).append(s.charAt(i));
                }
            }
        }
        
        StringBuffer sb = new StringBuffer();
        for (StringBuffer stringBuffer : list) {
            sb.append(stringBuffer);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode6 obj = new LeetCode6();
        System.out.println(obj.convert("PAYPALISHIRING", 3));
        System.out.println(obj.convert("PAYPALISHIRING", 4));
        System.out.println(obj.convert("A", 1));
        System.out.println(obj.convert("AB", 1));
    }
}
