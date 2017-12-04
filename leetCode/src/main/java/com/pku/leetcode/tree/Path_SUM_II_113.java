package com.pku.leetcode.tree;


/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */

import com.pku.leetcode.common.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhaolizhen on 17-12-4.
 */
public class Path_SUM_II_113 {

    public static void main(String args[]){
        TreeNode root=TreeUtils.createTree();
        Solution solution=new Solution();
        List<List<Integer>> result=solution.pathSum(root,6);
        CollectionUtils.print(result);
    }

    private static class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> results=new ArrayList<>();
            dfs(results,new LinkedList<Integer>(),root,sum);
            return results;
        }

        private void dfs(List<List<Integer>> result,LinkedList<Integer>resultPath,TreeNode root, int sum){
            if(root==null){
                return;
            }

            resultPath.addLast(root.val); //所在的位置很重要

            if(root.left==null&&root.right==null&&sum-root.val==0){
                result.add(new ArrayList<Integer>(resultPath));
            }

            dfs(result,resultPath,root.left,sum-root.val);
            dfs(result,resultPath,root.right,sum-root.val);
            resultPath.removeLast();

        }
    }
}
