package com.pku.leetcode.tree;

/**
 * Created by zhaolizhen on 18-3-10.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

 Example:

 Input: The root of a Binary Search Tree like this:
 5
 /   \
 2     13

 Output: The root of a Greater Tree like this:
 18
 /   \
 20     13
 */
public class Convert_BST_to_Greater_Tree_538 {

    public static void main(String args[]){
        Solution solution=new Solution();
        TreeNode root= TreeUtils.createTree();
        TreeNode result=solution.convertBST(root);
        TreeUtils.printTree(result);
    }

    private static class Solution {
        private int index=0;
        public TreeNode convertBST(TreeNode root) {
            List<Integer> list=new ArrayList<>();
            travel(root,list);
            int array[]=updateValue(list);
            convert(root, array);
            return root;
        }

        public void travel(TreeNode root,List<Integer>list){
            if(null==root){
                return;
            }
            travel(root.left, list);
            list.add(root.val);
            travel(root.right,list);
        }

        public int[] updateValue(List<Integer>list){
            int[]result=new int[list.size()];
            for(int i=list.size()-1;i>=0;i--){
                if(i==list.size()-1) {
                    result[i]=list.get(i);
                }else{
                    result[i] = result[i + 1] + list.get(i);
                }
            }
            return result;
        }

        public void convert(TreeNode root,int[]array){
            if(null==root){
                return;
            }
            convert(root.left, array);
            root.val=array[index++];
            convert(root.right, array);
        }
    }
}
