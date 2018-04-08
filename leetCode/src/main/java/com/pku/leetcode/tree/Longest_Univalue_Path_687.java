package com.pku.leetcode.tree;

/**
 * Created by zhaolizhen on 18-4-7.
 */

/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

 Note: The length of path between two nodes is represented by the number of edges between them.

 Example 1:

 Input:

 5
 / \
 4   5
 / \   \
 1   1   5
 Output:

 2
 Example 2:

 Input:

 1
 / \
 4   5
 / \   \
 4   4   5
 Output:

 2
 Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class Longest_Univalue_Path_687 {

    public static void main(String args[]){
        TreeNode root=TreeUtils.createTree();
        Solution solution=new Solution();
        System.out.println(solution.longestUnivaluePath(root));
    }

    //Accepted
    private static class Solution {
        private int max=0;
        public int longestUnivaluePath(TreeNode root) {
            if(root==null){
                return 0;
            }

            search(root);
            return max;
        }

        public void search(TreeNode root){
            if(null==root){
                return;
            }

            int value=longestUnivaluePathFromChild(root.left,root.val)+longestUnivaluePathFromChild(root.right,root.val);
            max=Math.max(max,value);
            search(root.left);
            search(root.right);
        }

        private int longestUnivaluePathFromChild(TreeNode root,int value){
            if(null==root){
                return 0;
            }
            int left=0,right=0;

            if(root.val!=value){
                return 0;
            }

            left=longestUnivaluePathFromChild(root.left, value)+1;

            right=longestUnivaluePathFromChild(root.right, value)+1;

            return Math.max(left,right);

        }
    }
}
