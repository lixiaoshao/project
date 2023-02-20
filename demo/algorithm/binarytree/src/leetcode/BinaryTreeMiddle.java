package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode
 *
 * @author honor-ljp
 * 2023/1/28 14:15
 */
public class BinaryTreeMiddle {
    public static void main(String[] args) {
        /*Tree tree = new Tree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(6);
        tree.insert(2);
        System.out.println("tree.root = " + tree.root);*/
        /*TreeNode treeNode = new TreeNode(10);
        TreeNode treeNode21 = new TreeNode(5);
        TreeNode treeNode22 = new TreeNode(15);
        TreeNode treeNode31 = new TreeNode(6);
        TreeNode treeNode32 = new TreeNode(2);
        treeNode.left = treeNode21;
        treeNode.right = treeNode22;
        treeNode22.left = treeNode31;
        treeNode22.right = treeNode32;*/

        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode22 = new TreeNode(2);
        TreeNode treeNode31 = new TreeNode(3);
        treeNode.right = treeNode22;
        treeNode22.left = treeNode31;
        List<Integer> list = inorderTraversal(treeNode);
        list.forEach(System.out::println);
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Tree.print(root, list);
        return list;
    }

}
