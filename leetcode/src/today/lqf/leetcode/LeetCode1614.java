package today.lqf.leetcode;

public class LeetCode1614 {
    
    public int maxDepth(String s) {
        int deep = 0, size = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                size++;
                deep = Math.max(deep,  size);
            } else if (c == ')') {
                size--;
            }
        }
        return deep;
    }
    
    public static void main(String[] args) {
        LeetCode1614 obj = new LeetCode1614();
        int rst = obj.maxDepth("(1+(2*3)+((8)/4))+1");
        System.out.println(rst);

    }

}
