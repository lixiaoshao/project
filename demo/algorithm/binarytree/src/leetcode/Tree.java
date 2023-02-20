package leetcode;

import java.util.List;

/**
 * leetcode
 *
 * @author honor-ljp
 * 2023/1/28 14:14
 */
class Tree {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        // new StirngBuilder().append("a").append("b").toString() toString方法其实就是new String("ab"); 创建了新的对象，在堆里边
        String s5 = "a" + "b";
        System.out.println(s3 == s5);
        System.out.println(s3 == s4);
    }
    public static void print(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            print(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            print(root.right, list);
        }
    }
    public TreeNode root;

    public void insert(Integer val) {
        if (val == null) {
            return;
        }
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
            return;
        }
        insert(root, newNode);
    }
    public void insert(TreeNode node, TreeNode insertNode) {
        if (node.val < insertNode.val) {
            // 往右走
            if (node.right == null) {
                node.right = insertNode;
            } else {
                insert(node.right, insertNode);
            }
        } else if (node.val > insertNode.val) {
            // 往左走
            if (node.left == null) {
                node.left = insertNode;
            } else {
                insert(node.left, insertNode);
            }
        }
    }
}
