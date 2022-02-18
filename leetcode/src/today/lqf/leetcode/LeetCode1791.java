package today.lqf.leetcode;

public class LeetCode1791 {

    public int findCenter(int[][] edges) {
        int u = edges[0][0];
        int i = edges[0][1];

        if (u == edges[1][0] || u == edges[1][1]) {
            return u;
        } else {
            return i;
        }
    }

    public static void main(String[] args) {
        LeetCode1791 obj = new LeetCode1791();
        System.out.println(obj.findCenter(new int[][] { { 1, 2 }, { 2, 3 }, { 4, 2 } }));
        System.out.println(obj.findCenter(new int[][] { { 1, 2 }, { 5, 1 }, { 1, 3 }, { 1, 4 } }));

    }

}
