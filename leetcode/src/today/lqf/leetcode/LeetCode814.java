package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/binary-tree-pruning/
 */
public class LeetCode814 {
    
    public TreeNode pruneTree(TreeNode node) {
        if (node.left != null) {
            node.left = pruneTree(node.left);
        }            
        if (node.right != null) {
           node.right = pruneTree(node.right);
        }
        if (node.left == null && node.right == null && node.val == 0) {
            return null;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root =  new TreeNode(1);
        TreeNode right =  new TreeNode(0, new TreeNode(0), new TreeNode(1));
        root.right = right;
        LeetCode814 obj = new LeetCode814();
        System.out.println(obj.pruneTree(root));

    }

}
