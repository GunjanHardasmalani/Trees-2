//TC - O(n)
//SC- O(h)

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        int currSum = 0;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> currentSumStack = new Stack<>();

        while (root != null || !nodeStack.isEmpty()) {
            while (root != null) {
                nodeStack.push(root);
                currSum = currSum * 10 + root.val;
                currentSumStack.push(currSum);
                root = root.left;
            }

            root = nodeStack.pop();
            currSum = currentSumStack.pop();

            if (root.left == null && root.right == null) {
                sum += currSum;
            }

            root = root.right;
        }

        return sum;
    }
}

public class SumRoofToLeaf {
    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Calculate the sum of root-to-leaf paths
        int result = solution.sumNumbers(root);

        // Print the result
        System.out.println("Sum of root-to-leaf paths: " + result);
    }
}
