package com.pku.leetcode.tree;

/**
 * Created by zhaolizhen on 18-3-11.
 */

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

 Example:
 Given a binary tree
 1
 / \
 2   3
 / \
 4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class Diameter_of_Binary_Tree_543 {

    public static void main(String args[]){
        Solution solution=new Solution();
        TreeNode root=TreeUtils.createTree();
        System.out.println(solution.diameterOfBinaryTree(root));
    }

    private static class Solution {
        private int max=0;
        public int diameterOfBinaryTree(TreeNode root) {
            travle(root);
            return max;
        }

        public int travle(TreeNode root){
            if(null==root){
                return 0;
            }
            int left=travle(root.left);
            int right=travle(root.right);
            max=Math.max(max,left+right);
            return (left>right?left:right)+1;
        }


    }
}
