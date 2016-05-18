package xiaofei.algorithm;

public class PreOrderTraversal {
    public static void traversalRecursively(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        traversalRecursively(root.left);
        traversalRecursively(root.right);
    }

    public static void traversalCorecursively(BinaryTreeNode root) {
        class StackElement {
            BinaryTreeNode node;
            boolean leftVisited;
            boolean rightVisited;
        }
        StackElement[] stack = new StackElement[100];
        for (int i = 0; i < 100; ++i) {
            stack[i] = new StackElement();
        }
        int top = -1;
        stack[++top] = new StackElement();
        stack[top].node = root;
        while (top >= 0) {
            BinaryTreeNode node = stack[top].node;
            if (!stack[top].leftVisited) {
                System.out.print(node.data + " ");
                stack[top].leftVisited = true;
                if (node.left != null) {
                    stack[++top] = new StackElement();
                    stack[top].node = node.left;
                }
            } else if (!stack[top].rightVisited) {
                stack[top].rightVisited = true;
                if (node.right != null) {
                    stack[++top] = new StackElement();
                    stack[top].node = node.right;
                }
            } else {
                --top;
            }
        }

    }

}