package org.pktl.tree.inorder;

import org.pktl.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 牛客 BM24 二叉树的中序遍历
 */
public class Solution {

    List<Integer> list = new ArrayList<>();

    /**
     * 递归
     * @param root
     * @return
     */
    public int[] inorderTraversal (TreeNode root) {
        traverse(root);
        int[] ints = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return ints;
    }

    public int[] inorderTraversalStack(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            arrayList.add(pop.val);
            root = pop.right;
        }
        return arrayList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }
}
