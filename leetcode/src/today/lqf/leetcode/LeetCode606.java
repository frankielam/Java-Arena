package today.lqf.leetcode;

public class LeetCode606 {

    StringBuffer sb = new StringBuffer();

    public String tree2str(TreeNode root) {
        sb.append(root.val);

        if (root.left != null) {
            sb.append("(");
            tree2str(root.left);
            sb.append(")");
        }
        if (root.right != null) {
            if (root.left == null) {
                sb.append("()");
            }
            sb.append("(");
            tree2str(root.right);
            sb.append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
