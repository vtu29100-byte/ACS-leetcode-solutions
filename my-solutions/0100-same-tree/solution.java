class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes are null, so they match
        if (p == null && q == null) {
            return true;
        }
        
        // One is null and the other isn't, or their values don't match
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        // Recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
