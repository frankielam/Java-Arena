package today.lqf.leetcode;

public class LeetCode504 {

    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean neg = false;
        if (num < 0) {
            neg = true;
            num = 0 - num;
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        if (neg) 
            sb.append("-");

        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        LeetCode504 obj =  new LeetCode504();
        System.out.println(obj.convertToBase7(100));
        System.out.println(obj.convertToBase7(0));
        System.out.println(obj.convertToBase7(-100));
    }

}
