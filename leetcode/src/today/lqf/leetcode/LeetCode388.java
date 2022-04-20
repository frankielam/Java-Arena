package today.lqf.leetcode;

import java.util.Stack;

public class LeetCode388 {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int level = 0, len = 0, max = 0;
        Stack<String> stack = new Stack<>();

        for (String line : lines) {
            int t = 0;
            while (line.charAt(t) == '\t') {
                t++;
            }
            String pathOrFile = line.substring(t);
//            System.out.println(pathOrFile);
            if (line.indexOf('.') > 0) {
                while (t > 0 && t <= level) {
                    if (!stack.isEmpty()) {
                        String lastLine = stack.pop();
                        len -= lastLine.length();
                    }
                    level--;
                }
                int l = (t > level ? len : 0) + line.length();
                if (l > max) {
                    max = l;
                }
            } else {
                while (t <= level) {
                    int lstLen = 0;
                    if (!stack.isEmpty()) {
                        String lastLine = stack.pop();
                        lstLen = lastLine == null ? 0 : lastLine.length();
                    }
                    len = len - lstLen;
                    if (t < level) {
                        level--;
                    } else {
                        break;
                    }
                }
                len += pathOrFile.length();
                level = t;
                stack.add(pathOrFile);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode388 obj = new LeetCode388();

        System.out.println(obj.lengthLongestPath("a\n\tb\n\t\tc.txt\n\taaaa.txt"));
        System.out.println(obj.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
//        dir
//        \tsubdir1
//        \tsubdir2
//        \t\tfile.ext
        System.out.println(obj.lengthLongestPath(
                "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(obj.lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
    }

//    dir
//    \tsubdir1
//    \t\tfile1.ext
//    \t\tsubsubdir1
//    \tsubdir2
//    \t\tsubsubdir2
//    \t\t\tfile2.ext
}
