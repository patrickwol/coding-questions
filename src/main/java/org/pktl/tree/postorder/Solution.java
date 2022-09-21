package org.pktl.tree.postorder;

import org.pktl.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<Integer> list = new ArrayList<>();

    public int[] postorderTraversal (TreeNode root) {
        traverse(root);
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] postorderTraversalStack(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode peek = stack.peek();
            TreeNode right = peek.right;
            if (right != null && pre != right) {
                root = right;
            } else {
                pre = peek;
                arrayList.add(peek.val);
                stack.poll();
            }
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
        traverse(root.right);
        list.add(root.val);
    }
}
