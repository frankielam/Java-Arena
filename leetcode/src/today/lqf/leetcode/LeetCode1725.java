package today.lqf.leetcode;

public class LeetCode1725 {
    
    public int countGoodRectangles(int[][] rectangles) {
        int cnt = 0, max = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int l = rectangles[i][0];
            int w = rectangles[i][1];
            int r = Math.min(l, w);
            if (r > max) {
                cnt = 1;
                max = r;
            } else if (r == max){
                cnt++;
            }
            
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode1725 obj = new LeetCode1725();
        System.out.println(obj.countGoodRectangles(new int[][] {{5, 8}, {3, 9}, {5, 12}, {16, 5}}));
        System.out.println(obj.countGoodRectangles(new int[][] {{2, 3}, {3, 7}, {4, 3}, {3, 7}}));
        

    }

}
