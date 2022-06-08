package today.lqf.leetcode;

public class LeetCode1037 {

    public boolean isBoomerang(int[][] points) {
        if (points.length != 3)
            return false;
        return ((points[1][1] - points[0][1]) * (points[2][0] - points[0][0])) != ((points[1][0] - points[0][0])
                * (points[2][1] - points[0][1]));
    }

    public static void main(String[] args) {
        LeetCode1037 obj = new LeetCode1037();
        System.out.println(obj.isBoomerang(new int[][] { { 1, 1 }, { 2, 3 }, { 3, 2 } }));
        System.out.println(obj.isBoomerang(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 } }));

    }

}
