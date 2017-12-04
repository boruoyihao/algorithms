package com.pku.leetcode.tree;


/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

/**
 * Created by zhaolizhen on 17-12-4.
 */
public class Path_SUM_I_112 {
    public static void main(String args[]){
        TreeNode root=TreeUtils.createTree();
        Solution s=new Solution();
        System.out.println(s.hasPathSum(root,6));
    }
    private static class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            return dfs(root,sum);
        }

        private boolean dfs(TreeNode root,int sum){
            if(null==root){
                return false;
            }

            if(null==root.left&&null==root.right&&sum-root.val==0){
                return true;
            }
            return dfs(root.left,sum-root.val)||dfs(root.right,sum-root.val);
        }
    }
}
