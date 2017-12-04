package com.pku.leetcode.tree;


/**
 * You are given a binary tree in which each node contains an integer value.

 Find the number of paths that sum to a given value.

 The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 Example:

 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

 10
 /  \
 5   -3
 / \    \
 3   2   11
 / \   \
 3  -2   1

 Return 3. The paths that sum to 8 are:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11
 */

/**
 * Created by zhaolizhen on 17-12-4.
 */
public class Path_Sum_III_437 {

    public static void main(String args[]){
        //[1,-2,-3,1,3,-2,null,-1]
        //-1
        TreeNode root=TreeUtils.createTree();
        Solution solution=new Solution();
        System.out.println(solution.pathSum(root, -1));
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    private static class Solution {

        public int pathSum(TreeNode root, int sum) {
            return getPaths(root,sum);
        }

        private int getPaths(TreeNode root,int sum){
            if(root==null){
                return 0;
            }
            return getPathFromRoot(root,sum)+getPaths(root.left, sum)+getPaths(root.right,sum);
        }

        private int getPathFromRoot(TreeNode root,int sum){
            if(null==root){
                return 0;
            }
            return (sum==root.val?1:0)+getPathFromRoot(root.left, sum - root.val)+getPathFromRoot(root.right, sum - root.val);
        }
    }
}
