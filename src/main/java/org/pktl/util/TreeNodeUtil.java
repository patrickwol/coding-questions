package org.pktl.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.text.CharPool;
import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeUtil {

    /**
     * 根据字符串构建二叉树，二叉树节点间空格分隔，null节点用#表示
     * 字符串为二叉树的层次遍历
     *
     * @param s
     * @return
     */
    public static TreeNode convertStringToTree(String s) {
        List<String> nodeList = StrUtil.split(s, CharPool.SPACE, -1, true, Convert::toStr);
        int size = nodeList.size();
        int height = getHeight(size);
        int fullNodeCount = (int) Math.pow(2, height) - 1;
        for (int i = 0; i < fullNodeCount - size; i++) {
            nodeList.add("#");
        }
        return createBinaryTree(nodeList);
    }

    public static void print(TreeNode root) {
        List<List<String>> lines = new ArrayList<List<String>>();

        List<TreeNode> level = new ArrayList<TreeNode>();
        List<TreeNode> next = new ArrayList<TreeNode>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (TreeNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.val + "";
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<TreeNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1)
                .size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }

    private static TreeNode createBinaryTree(List<String> list) {
        //构建和原数组相同的树节点列表
        List<TreeNode> treeNodeList = list.size() > 0 ? new ArrayList<>(list.size()) : null;
        TreeNode root = null;
        //把输入数值数组，先转化为二叉树节点列表
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = null;
            if (!StrUtil.equals("#", list.get(i))) {
                //用-1表示null
                node = new TreeNode(Integer.parseInt(list.get(i)));
            }
            treeNodeList.add(node);
            if (i == 0) {
                root = node;
            }
        }
        //遍历一遍，根据规则左右孩子赋值即可，注意这里结束规则是
        //i * 2 + 2 < arr.length 避免空指针
        for (int i = 0; i * 2 + 2 < list.size(); i++) {
            TreeNode node = treeNodeList.get(i);
            if (node != null) {
                node.left = treeNodeList.get(2 * i + 1);
                node.right = treeNodeList.get(2 * i + 2);
            }
        }
        return root;
    }

    private static int getHeight(int listSize) {
        double v = log(2, listSize);
        return (int) Math.floor(v) + 1;
    }

    private static double log(int base, int n) {
        return Math.log(n) / Math.log(base);
    }
}
