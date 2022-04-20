package today.lqf.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode388 {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int level = 0, len = 0, max = 0;
        Queue<String> queue = new LinkedList<>();

        for (String line : lines) {
            int t = 0;
            while (line.charAt(t) == '\t') {
                t++;
            }
            String pathOrFile = line.substring(t);
            System.out.println(pathOrFile);
            if (line.indexOf('.') > 0) {
                int l = len + line.length();
                if (l > max) {
                    max = l;
                }
            } else {

                while (t <= level) {
                    String lastLine = queue.poll();
                    int lstLen = lastLine == null ? 0 : lastLine.length();
//                    len--
                    len = len - lstLen;
                    if (t < level) {
                        level--;
                    }
                    else {
                        break;
                    }
                }
                len += pathOrFile.length();
                level = t;
                queue.add(pathOrFile);
            }
//            System.out.println(len);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode388 obj = new LeetCode388();
        System.out.println(obj.lengthLongestPath(
                "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(obj.lengthLongestPath(
                "dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext"));

     
    }

//    dir
//    \tsubdir1
//    \t\tfile1.ext
//    \t\tsubsubdir1
//    \tsubdir2
//    \t\tsubsubdir2
//    \t\t\tfile2.ext
}
