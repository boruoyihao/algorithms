package com.pku.leetcode.tree;

/**
 * Created by zhaolizhen on 18-5-21.
 */

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:
 3
 / \
 2   3
 \   \
 3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 Example 2:
 3
 / \
 4   5
 / \   \
 1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class House_Robber_III_337 {

    public static void main(String args[]){
        TreeNode root=TreeUtils.createTree();

        Solution solution=new Solution();
        System.out.println(solution.rob(root));

    }

    private static class  Solution {
        public int rob(TreeNode root) {
            if(null==root){
                return 0;
            }
            return rob(root,true,0)+rob(root,false,0);
        }

        public int rob(TreeNode root,boolean choose,int sum){
            if(root==null){
                return 0;
            }

            if(choose){
                sum+=root.val;
            }
            return rob(root.left,!choose,sum)+rob(root.right,!choose,sum);
        }
    }
}
