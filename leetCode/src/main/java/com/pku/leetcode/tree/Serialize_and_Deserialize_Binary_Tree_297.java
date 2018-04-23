package com.pku.leetcode.tree;

/**
 * Created by zhaolizhen on 18-4-23.
 */

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

 Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

 For example, you may serialize the following tree

 1
 / \
 2   3
 / \
 4   5
 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.



 Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

 Credits:
 Special thanks to @Louis1992 for adding this problem and creating all test cases.
 */
public class Serialize_and_Deserialize_Binary_Tree_297 {


    public static void main(String args[]){
        TreeNode root=TreeUtils.createTree();
        Codec codec=new Codec();
        String data=codec.serialize(root);
        System.out.println("data="+data);
        TreeNode result=codec.deserialize(data);
        TreeUtils.printTree(result);
    }


    private static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb=new StringBuilder();
            preOrder(root,sb);
            return sb.toString();
        }

        private void preOrder(TreeNode root,StringBuilder sb){
            if(root==null){
                sb.append("*").append("#");
                return;
            }
            sb.append(root.val).append("#");
            preOrder(root.left, sb);
            preOrder(root.right,sb);

        }

        private int index=0;
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[]buffer=data.split("#");
            index=0;
            return createTreeNode(buffer);
        }

        private TreeNode createTreeNode(String[]buffer){
            if(index>=buffer.length){
                return null;
            }

            String data=buffer[index++];
            if(data.equals("*")){
                return null;
            }

            TreeNode treeNode=new TreeNode(Integer.parseInt(data));
            treeNode.left=createTreeNode(buffer);
            treeNode.right=createTreeNode(buffer);
            return treeNode;
        }
    }
}
