package com.pku.leetcode.tree;

/**
 * Created by zhaolizhen on 18-3-11.
 */

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 * <p>
 * Example 1:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return false.
 */
public class Subtree_of_Another_Tree {

    public static void main(String args[]) {
        TreeNode s = TreeUtils.createTree();
        TreeNode t = TreeUtils.createTree();
        Solution solution = new Solution();
        System.out.println(solution.isSubtree(s, t));
    }

    private static class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (null == s) {
                return false;
            }
            if (null != t && s.val == t.val&&compare(s,t)) {
                return true;
            }

            //if (null != t && s.val == t.val&&compare(s,t)) {
            //return true;
            //}  注意这两写法的区别
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }


        public boolean compare(TreeNode s, TreeNode t) {
            if (null == t && null == s) {
                return true;
            }
            if (null == s || null == t) {
                return false;
            }
            if (s.val == t.val) {
                return compare(s.left, t.left) && compare(s.right, t.right);
            }
            return false;
        }
    }
}
