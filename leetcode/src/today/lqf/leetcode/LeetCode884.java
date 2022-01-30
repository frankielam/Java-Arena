package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        StringBuffer sb = new StringBuffer(s1);
        sb.append(" ").append(s2);
        String[] arr = sb.toString().split(" ");
        Arrays.sort(arr);
        String str = new String();
        int cnt = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i].equals(str)) {
                if (cnt == 1) {
                    list.add(str);
                }
                str = arr[i];
                cnt = 1;
            } else {
                cnt++;
            }
            if (i == arr.length - 1) {
                if (cnt == 1) {
                    list.add(str);
                }
            }
        }
        
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        LeetCode884 obj = new LeetCode884();
        String s1 = "apple apple this";
        String s2 = "banana that";
        System.out.println(Arrays.toString(obj.uncommonFromSentences(s1, s2)));
        
    }
}
