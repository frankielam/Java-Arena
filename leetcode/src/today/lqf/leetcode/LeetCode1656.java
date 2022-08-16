package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.cn/problems/design-an-ordered-stream/
 */
public class LeetCode1656 {

    int ptr = 0;

    String[] arrays;

    public LeetCode1656(int n) {
        arrays = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        arrays[idKey - 1] = value;
        List<String> list = new ArrayList<>();
        for (int i = ptr; i < arrays.length; i++) {
            if (arrays[i] != null && arrays[i].length() > 0) {
                list.add(arrays[i]);
                ptr++;
            } else {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
