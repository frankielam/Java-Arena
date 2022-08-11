package today.lqf.leetcode;

public class LeetCode1417 {
    
    public String reformat(String s) {
        int l = 0, n = 0; 
        char[] str = new char[s.length()];
        char lastChar = ' ';
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (n*2 < s.length()) {
                    str[n*2] = c;
                }
                n++;
            } else {
                if (l*2+1 < s.length()) {
                    str[l*2+1] = c;
                } else {
                    lastChar = c;
                }
                l++;
            }
        }
        if (Math.abs(l-n) > 1) {
            return "";
        } else if (l > n) {
            return lastChar + new String(str).substring(0, s.length()-1);
        }
        
        return new String(str);
    }

    public static void main(String[] args) {
        LeetCode1417 obj = new LeetCode1417();
        System.out.println(obj.reformat("a0b1c2"));
        System.out.println(obj.reformat("abc12"));
        System.out.println(obj.reformat("abc1234"));

    }

}
