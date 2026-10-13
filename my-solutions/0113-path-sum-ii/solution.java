class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, result);
        return result;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // Add the current node value to the path
        currentPath.add(node.val);

        // Check if it's a leaf node and the remaining target sum equals the node's value
        if (node.left == null && node.right == null && targetSum == node.val) {
            // Make a copy of currentPath before adding to result
            result.add(new ArrayList<>(currentPath));
        } else {
            // Recurse on left and right children with updated target sum
            dfs(node.left, targetSum - node.val, currentPath, result);
            dfs(node.right, targetSum - node.val, currentPath, result);
        }

        // Backtrack: remove the current node from path
        currentPath.remove(currentPath.size() - 1);
    }
}
