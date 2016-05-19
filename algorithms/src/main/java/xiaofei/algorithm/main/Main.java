/**
 *
 * Copyright 2016 Xiaofei
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package xiaofei.algorithm.main;

import xiaofei.algorithm.BinaryTreeNode;
import xiaofei.algorithm.EightQueensPuzzle;
import xiaofei.algorithm.InOrderTraversal;
import xiaofei.algorithm.PostOrderTraversal;
import xiaofei.algorithm.PreOrderTraversal;

/**
 * Created by Xiaofei on 16/5/18.
 */

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

    private static void eightQueensPuzzle() {
        System.out.println("\nEightQueensPuzzle");
        EightQueensPuzzle.calculate();
    }

    public static void main(String[] args) {
        BinaryTreeNode root = build();
        preOrderTraversal(root);
        inOrderTraversal(root);
        postOrderTraversal(root);
        eightQueensPuzzle();
    }
}
