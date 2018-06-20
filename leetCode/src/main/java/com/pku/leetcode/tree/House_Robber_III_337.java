package com.pku.leetcode.tree;

/**
 * Created by zhaolizhen on 18-5-21.
 */
//https://leetcode.com/problems/house-robber-iii/description/

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area,
 * called the "root." Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class House_Robber_III_337 {

    public static void main(String args[]) {
        TreeNode root = TreeUtils.createTree();

        Solution solution = new Solution();
        System.out.println(solution.rob(root));

    }

    //recursion way to solve this problem
    //https://leetcode.com/problems/house-robber-iii/discuss/79344/Easy-to-understand(java)
    private static class Solution2 {

        public int rob(TreeNode root) {
            if (root == null) return 0;
            return Math.max(robInclude(root), robExclude(root));
        }

        public int robInclude(TreeNode node) {
            if (node == null) return 0;
            return robExclude(node.left) + robExclude(node.right) + node.val;
        }

        public int robExclude(TreeNode node) {
            if (node == null) return 0;
            return rob(node.left) + rob(node.right);
        }
    }

    //https://leetcode.com/problems/house-robber-iii/discuss/138927/Java-Recursive-beats-92
    private static class Solution {
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Pair result = robHelper(root);
            return Math.max(result.with, result.without);
        }

        private Pair robHelper(TreeNode root) {
            if (null == root) {
                return new Pair(0, 0);
            }

            Pair leftPair = robHelper(root.left);
            Pair rightPair = robHelper(root.right);
            int with = root.val + leftPair.without + rightPair.without;
            int without = max(leftPair.with + rightPair.with, leftPair.with + rightPair.without,
                    leftPair.without + rightPair.with, leftPair.without + rightPair.without);
            return new Pair(with, without);
        }

        int max(int data1, int data2, int data3, int data4) {
            return Math.max(Math.max(data1, data2), Math.max(data3, data4));
        }


        private class Pair {
            int with;
            int without;

            Pair(int with, int without) {
                this.with = with;
                this.without = without;
            }
        }
    }


}
