package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/successor-lcci/
 */
public class LeetCode0406 {

    boolean ready;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        ready = false;
        return search(root, p);
    }

    private TreeNode search(TreeNode node, TreeNode p) {
        if (node.left != null && p.val < node.val) {
            TreeNode tmp = search(node.left, p);
            if (tmp != null) {
                return tmp;
            }
        }
        if (ready) {
            return node;
        }
        if (node.val == p.val) {
            ready = true;
        }
        if (node.right != null && p.val >= node.val) {
            TreeNode tmp = search(node.right, p);
            if (tmp != null) {
                return tmp;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LeetCode0406 obj = new LeetCode0406();

    }

}
