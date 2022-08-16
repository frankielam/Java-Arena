package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/deepest-leaves-sum/
 */
public class LeetCode1302 {

    int total = 0;
    int level = 1;

    public int deepestLeavesSum(TreeNode root) {
        df(root, 1);
        return total;
    }

    private void df(TreeNode node, int level) {
        if (this.level == level) {
            this.total += node.val;
            if (node.left != null || node.right != null) {
                this.level++;
                this.total = 0;
            }
        }
        if (node.left != null) {
            df(node.left, level + 1);
        }
        if (node.right != null) {
            df(node.right, level + 1);
        }

    }

    public static void main(String[] args) {
//        LeetCode1302 obj = new LeetCode1302();
       
    }

}
