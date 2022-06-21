package today.lqf.leetcode;

public class LeetCode1108 {

    public String defangIPaddr(String address) {
        int len = address.length();
        char[] ip = new char[len+6];

        for (int i = 0, j = 0; i < len; i++) {
            if (address.charAt(i) == '.') {
                ip[j++] = '[';
                ip[j++] = '.';
                ip[j++] = ']';
            } else {
                ip[j++] = address.charAt(i);
            }
        }
        return new String(ip);
    }
    
    public static void main(String[] args) {
        LeetCode1108 obj = new LeetCode1108();
        System.out.println(obj.defangIPaddr("1.1.1.1"));
        System.out.println(obj.defangIPaddr("255.100.50.0"));
    }
}
