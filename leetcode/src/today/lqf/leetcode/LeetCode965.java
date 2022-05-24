package today.lqf.leetcode;

public class LeetCode965 {

    public boolean isUnivalTree(TreeNode root) {
        if (root.left != null) {
            if (root.val != root.left.val) {
                return false;
            }
            if (!isUnivalTree(root.left)) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val != root.right.val) {
                return false;
            }
            if (!isUnivalTree(root.right)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode965 obj = new LeetCode965();
//        System.out.println(obj.isUnivalTree(null));
    }

}
