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

import java.util.Random;

import xiaofei.algorithm.AckermannFunction;
import xiaofei.algorithm.BinarySearchTree;
import xiaofei.algorithm.BinaryTreeHeight;
import xiaofei.algorithm.BinaryTreeNode;
import xiaofei.algorithm.DisjointSet;
import xiaofei.algorithm.EightDigitMaze;
import xiaofei.algorithm.EightQueensPuzzle;
import xiaofei.algorithm.InOrderTraversal;
import xiaofei.algorithm.KnightCruise;
import xiaofei.algorithm.PostOrderTraversal;
import xiaofei.algorithm.PreOrderTraversal;
import xiaofei.algorithm.QuickSort;

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

    private static void binarySearchTreeNoDeletion() {
        System.out.println("\nbinarySearchTreeNoDeletion");
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.output();
    }

    private static void binarySearchTreeDeleteLeaf() {
        System.out.println("\nbinarySearchTreeDeleteLeaf");
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.delete(6);
        tree.output();
    }


    private static void binarySearchTreeDeleteNoRight() {
        System.out.println("\nbinarySearchTreeDeleteNoRight");
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(8);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.delete(8);
        tree.output();
    }

    private static void binarySearchTreeDeleteNoLeft() {
        System.out.println("\nbinarySearchTreeDeleteNoLeft");
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(8);
        tree.insert(10);
        tree.insert(11);
        tree.delete(8);
        tree.output();
    }

    private static void binarySearchTreeDelete() {
        System.out.println("\nbinarySearchTreeDelete");
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(8);
        tree.insert(10);
        tree.insert(11);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.delete(8);
        tree.output();
    }

    private static void binarySearchTreeDeleteRootLeaf() {
        System.out.println("\nbinarySearchTreeDeleteRootLeaf");
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(3);
        tree.delete(3);
        tree.output();
    }


    private static void binarySearchTreeDeleteRootNoRight() {
        System.out.println("\nbinarySearchTreeDeleteRootNoRight");
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);
        tree.delete(4);
        tree.output();
    }

    private static void binarySearchTreeDeleteRootNoLeft() {
        System.out.println("\nbinarySearchTreeDeleteRootNoLeft");
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(3);
        tree.insert(5);
        tree.insert(8);
        tree.insert(6);
        tree.delete(3);
        tree.output();
    }

    private static void binarySearchTreeDeleteRoot() {
        System.out.println("\nbinarySearchTreeDeleteRoot");
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(8);
        tree.insert(2);
        tree.insert(5);
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);
        tree.delete(8);
        tree.output();
    }

    private static void binarySearchTree() {
        binarySearchTreeNoDeletion();
        binarySearchTreeDeleteLeaf();
        binarySearchTreeDeleteNoRight();
        binarySearchTreeDeleteNoLeft();
        binarySearchTreeDelete();
        binarySearchTreeDeleteRootLeaf();
        binarySearchTreeDeleteRootNoRight();
        binarySearchTreeDeleteRootNoLeft();
        binarySearchTreeDeleteRoot();
    }


    private static void binaryTreeHeight() {
        System.out.println("\nBinaryTreeHeight");
        System.out.println(BinaryTreeHeight.calculateCorecursively(null));
        System.out.println(BinaryTreeHeight.calculateRecursively(null));
        BinaryTreeNode node0 = new BinaryTreeNode(),
                node1 = new BinaryTreeNode(),
                node2 = new BinaryTreeNode(),
                node3 = new BinaryTreeNode(),
                node4 = new BinaryTreeNode(),
                node5 = new BinaryTreeNode();
        node0.data = 0; node1.data = 1; node2.data = 2; node3.data = 3; node4.data = 4; node5.data = 5;
        System.out.println(BinaryTreeHeight.calculateCorecursively(node0));
        System.out.println(BinaryTreeHeight.calculateRecursively(node0));
        node0.left = node1;
        System.out.println(BinaryTreeHeight.calculateCorecursively(node0));
        System.out.println(BinaryTreeHeight.calculateRecursively(node0));
        node0.left = null; node0.right = node1;
        System.out.println(BinaryTreeHeight.calculateCorecursively(node0));
        System.out.println(BinaryTreeHeight.calculateRecursively(node0));
        node0.left = node1; node0.right = node2;
        node2.left = node3; node2.right = node4;
        node4.right = node5;
        System.out.println(BinaryTreeHeight.calculateCorecursively(node0));
        System.out.println(BinaryTreeHeight.calculateRecursively(node0));
    }

    private static void disjointSet() {
        System.out.println("\nDisjointSet");
        DisjointSet<Integer> disjointSet = new DisjointSet<>();
        for (int i = 0; i < 8; ++i) {
            disjointSet.makeSet(i);
        }
        disjointSet.union(0, 1);
        disjointSet.union(2, 3);
        disjointSet.union(2, 4);
        disjointSet.union(0, 2);
        disjointSet.union(5, 6);
        disjointSet.union(5, 7);
        for (int i = 0; i < 8; ++i) {
            System.out.println(disjointSet.find(i));
        }
    }

    private static void knightCruise() {
        System.out.println("\nKnightCruise Recursive");
        KnightCruise.solve(true);
        System.out.println("\nKnightCruise Corecursive");
        KnightCruise.solve(false);
    }

    private static void ackermannFunction() {
        System.out.println("\nAckermannFunction recursive");
        for (int m = 0; m <= 3; ++m) {
            for (int n = 0; n <= 4; ++n) {
                System.out.println("Ack(" + m + "," + n + ")=" + AckermannFunction.calculateRecursively(m, n));
            }
        }
        System.out.println("\nAckermannFunction corecursive");
        for (int m = 0; m <= 3; ++m) {
            for (int n = 0; n <= 4; ++n) {
                System.out.println("Ack(" + m + "," + n + ")=" + AckermannFunction.calculateCorecursively(m, n));
            }
        }
    }

    private static void quickSort() {
        System.out.println("\nQuickSort Recursively\n");
        Random random = new Random();
        final int size = 20;
        int[] arr = new int[size];
        for (int k = 0; k < 3; ++k) {
            for (int i = 0; i < size; ++i) {
                arr[i] = random.nextInt(100);
            }
            System.out.println("Before");
            for (int i = 0; i < size; ++i) {
                System.out.print(" " + arr[i]);
            }
            System.out.println();
            QuickSort.sort(arr, true);
            System.out.println("After");
            for (int i = 0; i < size; ++i) {
                System.out.print(" " + arr[i]);
            }
            System.out.println();
        }
        System.out.println("\nQuickSort Corecursively\n");
        for (int k = 0; k < 3; ++k) {
            for (int i = 0; i < size; ++i) {
                arr[i] = random.nextInt(100);
            }
            System.out.println("Before");
            for (int i = 0; i < size; ++i) {
                System.out.print(" " + arr[i]);
            }
            System.out.println();
            System.out.println("After");
            QuickSort.sort(arr, false);
            for (int i = 0; i < size; ++i) {
                System.out.print(" " + arr[i]);
            }
            System.out.println();
        }
    }

    private static void eightDigitMaze() {
        System.out.println("\nEightDigitMaze1");
        EightDigitMaze.solve(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}} , new int[][]{{1, 2, 3}, {4, 5, 0}, {7, 8, 6}});
        System.out.println("\nEightDigitMaze2");
        EightDigitMaze.solve(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}} , new int[][]{{1, 3, 2}, {7, 4, 0}, {5, 8, 6}});
        System.out.println("\nEightDigitMaze3");
        EightDigitMaze.solve(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}} , new int[][]{{1, 5, 2}, {7, 4, 3}, {8, 6, 0}});
        System.out.println("\nEightDigitMaze4");
        EightDigitMaze.solve(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}} , new int[][]{{5, 0, 2}, {1, 7, 3}, {8, 4, 6}});
    }

    public static void main(String[] args) {
        BinaryTreeNode root = build();
        preOrderTraversal(root);
        inOrderTraversal(root);
        postOrderTraversal(root);
        eightQueensPuzzle();
        binarySearchTree();
        binaryTreeHeight();
        disjointSet();
        knightCruise();
        ackermannFunction();
        quickSort();
        eightDigitMaze();
    }
}
