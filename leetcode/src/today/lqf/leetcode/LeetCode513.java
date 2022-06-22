package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 */
public class LeetCode513 {

    int maxDeep = 0;
    int target = -1;
    
    public int findBottomLeftValue(TreeNode root) {
        maxDeep = 0;
        target = -1;
        dfs(root, 1);
        return target;
    }

    private void dfs(TreeNode node, int deep) {
        if (node.left == null && node.right == null) {
            if (deep > maxDeep) {
                target = node.val;
                maxDeep = deep;
            }
        } else {
            if (node.left != null) {
                dfs(node.left, deep+1);
            }
            if (node.right != null) {
                dfs(node.right, deep+1);
            }
        }
    }
    
    public static void main(String[] args) {
        LeetCode513 obj = new LeetCode513();

    }

}
