package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/add-one-row-to-tree/
 */
public class LeetCode623 {

    int nodeValue, nodeDepth;

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        nodeValue = val;
        nodeDepth = depth - 1;
        if (nodeDepth == 0) {
            return new TreeNode(nodeValue, root, null);
        }
        handle(root, 1);
        return root;
    }

    private void handle(TreeNode node, int curDepth) {
        if (curDepth < nodeDepth) {
            if (node.left != null) {
                handle(node.left, curDepth + 1);
            }
            if (node.right != null) {
                handle(node.right, curDepth + 1);
            }
        } else if (curDepth == nodeDepth) {
            if (node.left != null) {
                node.left = new TreeNode(nodeValue, node.left, null);
            } else {
                node.left = new TreeNode(nodeValue);
            }
            if (node.right != null) {
                node.right = new TreeNode(nodeValue, null, node.right);
            } else {
                node.right = new TreeNode(nodeValue);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode623 obj = new LeetCode623();
        TreeNode node = new TreeNode(2, new TreeNode(3), new TreeNode(1));
        TreeNode root = new TreeNode(4, node, null);
        System.out.println(obj.addOneRow(root, 1, 3));
    }

}
