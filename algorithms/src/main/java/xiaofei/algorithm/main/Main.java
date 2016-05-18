package xiaofei.algorithm.main;

import xiaofei.algorithm.BinaryTreeNode;
import xiaofei.algorithm.InOrderTraversal;
import xiaofei.algorithm.PostOrderTraversal;
import xiaofei.algorithm.PreOrderTraversal;

public class Main {

    private static BinaryTreeNode build() {
        BinaryTreeNode node0 = new BinaryTreeNode();
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        node0.data = 0; node0.left = node1; node0.right = node2;
        node1.data = 1;
        node2.data = 2; node2.left = node3; node2.right = node4;
        node3.data = 3;
        node4.data = 4;
        return node0;
    }

    private static void preOrderTraversal(BinaryTreeNode root) {
        System.out.println("\nPreOrderTraversalRecursively");
        PreOrderTraversal.traversalRecursively(root);
        System.out.println("\nPreOrderTraversalCorecursively");
        PreOrderTraversal.traversalCorecursively(root);
    }

    private static void inOrderTraversal(BinaryTreeNode root) {
        System.out.println("\nInOrderTraversalRecursively");
        InOrderTraversal.traversalRecursively(root);
        System.out.println("\nInOrderTraversalCorecursively");
        InOrderTraversal.traversalCorecursively(root);
    }

    private static void postOrderTraversal(BinaryTreeNode root) {
        System.out.println("\nPostOrderTraversalRecursively");
        PostOrderTraversal.traversalRecursively(root);
        System.out.println("\nPostOrderTraversalCorecursively");
        PostOrderTraversal.traversalCorecursively(root);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = build();
        preOrderTraversal(root);
        inOrderTraversal(root);
        postOrderTraversal(root);
    }
}
