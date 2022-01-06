package today.lqf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode71 {

    public String simplifyPath(String path) {
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) != '/') {
                sb.append(path.charAt(i));
                if (i != path.length() - 1)
                    continue;
            }
            if (sb.length() > 0) {
                if (sb.toString().equals("..")) {
                    if (list.size() > 0)
                        list.remove(list.size() - 1);
                } else {
                    if (!sb.toString().equals(".")) {
                        list.add(sb.toString());
                    }
                }
                sb = new StringBuffer();
            }

        }

        sb = new StringBuffer("/");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1)
                sb.append("/");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode71 obj = new LeetCode71();
        String s = obj.simplifyPath("/a//b////c/d//././/..");
        System.out.println(s);

    }

}
