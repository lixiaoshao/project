package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode
 *
 * @author honor-ljp
 * 2023/1/28 14:54
 */
public class BinaryTreeLayer {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        TreeNode treeNode21 = new TreeNode(4);
        TreeNode treeNode22 = new TreeNode(6);
        TreeNode treeNode31 = new TreeNode(1);
        TreeNode treeNode32 = new TreeNode(2);
        TreeNode treeNode33 = new TreeNode(7);
        TreeNode treeNode34 = new TreeNode(8);
        treeNode.left = treeNode21;
        treeNode.right = treeNode22;
        treeNode21.left = treeNode31;
        treeNode21.right = treeNode32;
        treeNode22.left = treeNode33;
        treeNode22.right = treeNode34;
        List<List<Integer>> lists = levelOrder(null);
        System.out.println("lists = " + lists);

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> nodeList = new LinkedList();
        List<List<Integer>> keys = new ArrayList<>();
        nodeList.offer(root);
        nodeList.offer(null);
        List<Integer> group = new ArrayList<>();
        while (!nodeList.isEmpty()) {
            TreeNode pop = nodeList.poll();
            if (pop != null) {
                group.add(pop.val);
                if (pop.left != null) {
                    nodeList.offer(pop.left);
                }
                if (pop.right != null) {
                    nodeList.offer(pop.right);
                }
            } else {
                keys.add(group);
                group = new ArrayList<>();
                if (!nodeList.isEmpty()) {
                    nodeList.offer(null);
                }
            }
        }
        return keys;
    }
}
