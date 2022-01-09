package today.lqf.leetcode;

public class LeetCode1629 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int time = releaseTimes[0];
        char rst = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int t = releaseTimes[i] - releaseTimes[i-1];
            if (t >= time) {
                if (t > time || rst < keysPressed.charAt(i)) {
                    rst = keysPressed.charAt(i);
                }
                time = t;
            }
        }
        return rst;
    }
    
    public static void main(String[] args) {
        LeetCode1629 obj = new LeetCode1629();
        char c = obj.slowestKey(new int[]{12,23,36,46,62}, "spuda");
        System.out.println(c);
        

    }

}
