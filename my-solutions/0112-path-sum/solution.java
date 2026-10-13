
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        
        // If it's a leaf node, check if the remaining targetSum equals node value
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        
        // Recurse on left and right children with updated target sum
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}
