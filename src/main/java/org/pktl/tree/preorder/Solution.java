package org.pktl.tree.preorder;

import org.pktl.util.TreeNode;

import java.util.*;

/**
 * 牛客 BM23 二叉树的前序遍历
 */
public class Solution {

    int[] arr = new int[100];
    int i = 0;

    /**
     * 递归
     * @param root
     * @return
     */
    public int[] preorderTraversal (TreeNode root) {
        traverse(root);
        int[] res = Arrays.copyOf(arr, i);
        return res;
    }

    /**
     * 栈
     */
    public int[] preorderTraversalStack (TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.poll();
            list.add(top.val);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
        return list.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        arr[i] = root.val;
        i++;
        traverse(root.left);
        traverse(root.right);
    }
}
