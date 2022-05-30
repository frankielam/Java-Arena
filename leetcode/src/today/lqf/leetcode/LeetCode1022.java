package today.lqf.leetcode;

/*
 * https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class LeetCode1022 {

    int total = 0;

    public int sumRootToLeaf(TreeNode root) {
        total = 0;
        sumNode(root, 0);
        return total;
    }

    private void sumNode(TreeNode node, int val) {
        if (node.left != null || node.right != null) {
            val += node.val;
            val <<= 1;
            if (node.left != null) {
                sumNode(node.left, val);
            }
            if (node.right != null) {
                sumNode(node.right, val);
            }
        } else {
            val += node.val;
            total += val;
        }
    }

    public static void main(String[] args) {
        LeetCode1022 obj = new LeetCode1022();
//        System.out.println(obj.sumRootToLeaf(null));

    }

}
