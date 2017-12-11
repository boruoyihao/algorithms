package com.pku.leetcode.tree;


import java.util.Scanner;

/**
 * Created by zhaolizhen on 17-12-4.
 */
public class TreeUtils {
    private static Scanner scanner = new Scanner(System.in);

    static TreeNode createTree() {
        TreeNode root = null;
        int value = scanner.nextInt();
        if (value == -1) {
            return root;
        }
        root = new TreeNode(value);
        root.left = createTree();
        root.right = createTree();

        return root;
    }

    static void printTree(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.print(root.val + "  ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String args[]){
        TreeNode root=createTree();
        printTree(root);
    }
}
