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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import xiaofei.algorithm.AckermannFunction;
import xiaofei.algorithm.BinarySearch;
import xiaofei.algorithm.BinarySearchTree;
import xiaofei.algorithm.BinaryTreeHeight;
import xiaofei.algorithm.BinaryTreeNode;
import xiaofei.algorithm.BinaryTreeWidth;
import xiaofei.algorithm.Dijkstra;
import xiaofei.algorithm.DisjointSet;
import xiaofei.algorithm.DoubleStackBasedCalculator;
import xiaofei.algorithm.EightDigitMaze;
import xiaofei.algorithm.EightQueensPuzzle;
import xiaofei.algorithm.EqualSum;
import xiaofei.algorithm.FindFirstInArray;
import xiaofei.algorithm.InOrderTraversal;
import xiaofei.algorithm.KnightCruise;
import xiaofei.algorithm.DoublyLinkedList;
import xiaofei.algorithm.Kruskal;
import xiaofei.algorithm.MissionariesAndCannibalsProblem;
import xiaofei.algorithm.PostOrderTraversal;
import xiaofei.algorithm.PreOrderTraversal;
import xiaofei.algorithm.Prim;
import xiaofei.algorithm.QuickSort;
import xiaofei.algorithm.SnakeMatrix;
import xiaofei.algorithm.TopologicalSort;
import xiaofei.algorithm.TwentyFourGame;
import xiaofei.algorithm.problem.BinaryTreeMaxScore;
import xiaofei.algorithm.problem.InOrderPostOrderToPreOrder;
import xiaofei.algorithm.problem.PreOrderInOrderToPostOrder;
import xiaofei.algorithm.problem.PreOrderPostOrderToInOrder;

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

    private static void doublyLinkedList() {
        System.out.println("\nDoublyLinkedList");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        //test add and get
        for (int i = 0; i < 10; ++i) {
            list.add(9 - i);
        }
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(" " + list.get(i));
        }
        System.out.println();
        //test indexOf
        System.out.println("index of 12: " + list.indexOf(12));
        System.out.println("index of 9: " + list.indexOf(9));
        System.out.println("index of 0: " + list.indexOf(0));
        list.clear();

        //test add(int, T)
        for (int i = 0; i < 10; ++i) {
            list.add(list.size(), 9 - i);
        }
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(" " + list.get(i));
        }
        System.out.println();
        List<Integer> array = list.reversedArray();
        for (int i = 0; i < array.size(); ++i) {
            System.out.print(" " + array.get(i));
        }
        System.out.println();
        list.clear();
        list.add(0, 1);
        list.add(0, 2);
        list.add(1, 3);
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(" " + list.get(i));
        }
        System.out.println();
        array = list.reversedArray();
        for (int i = 0; i < array.size(); ++i) {
            System.out.print(" " + array.get(i));
        }
        System.out.println();
        list.add(0, 4);
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(" " + list.get(i));
        }
        System.out.println();
        array = list.reversedArray();
        for (int i = 0; i < array.size(); ++i) {
            System.out.print(" " + array.get(i));
        }
        System.out.println();
        list.add(2, 5);
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(" " + list.get(i));
        }
        System.out.println();
        array = list.reversedArray();
        for (int i = 0; i < array.size(); ++i) {
            System.out.print(" " + array.get(i));
        }
        System.out.println();
        list.remove(4);
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(" " + list.get(i));
        }
        System.out.println();
        array = list.reversedArray();
        for (int i = 0; i < array.size(); ++i) {
            System.out.print(" " + array.get(i));
        }
        System.out.println();
        list.remove(2);
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(" " + list.get(i));
        }
        System.out.println();
        array = list.reversedArray();
        for (int i = 0; i < array.size(); ++i) {
            System.out.print(" " + array.get(i));
        }
    }

    private static void doubleStackBasedCalculator() {
        System.out.println("\nDoubleStackBasedCalculator");
        String[] inputs = new String[]{
                "32+21",
                "32+21*3",
                "3+(8+9)",
                "30+3+31/7*9*(9+1*2*71+2-90)",
                "30+(3+31/7)*9*(9+1*2*(71+2*90))",
        };
        for (String input : inputs) {
            System.out.println(DoubleStackBasedCalculator.solve(input));
        }
    }

    private static void topologicalSort() {
        System.out.println("\nTopologicalSort");
        TopologicalSort topologicalSort = new TopologicalSort(8);
        topologicalSort.link(0, 3);
        topologicalSort.link(1, 3);
        topologicalSort.link(1, 4);
        topologicalSort.link(2, 4);
        topologicalSort.link(2, 7);
        topologicalSort.link(3, 5);
        topologicalSort.link(3, 6);
        topologicalSort.link(3, 7);
        topologicalSort.link(4, 6);
        topologicalSort.link(7, 5);
        List<Integer> list = topologicalSort.solve();
        for (Integer i : list) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    private static void twentyFourGame() {
        System.out.println("\nTwentyFourGame");
        for (int a = 1; a <= 13; ++a) {
            for (int b = a; b <= 13; ++b) {
                for (int c = b; c <=13; ++c) {
                    for (int d = c; d <= 13; ++d) {
                        TwentyFourGame.solve(a, b, c, d);
                    }
                }
            }
        }
    }

    private static void snakeMatrix() {
        System.out.println("\nSnakeMatrix");
        for (int i = 1; i <= 10; ++i) {
            SnakeMatrix.solve(i);
        }
    }

    private static void missionariesAndCannibalsProblem() {
        System.out.println("\nMissionariesAndCannibalsProblem");
        MissionariesAndCannibalsProblem.solve();
    }

    private static void equalSum() {
        System.out.println("\nEqualSum");
        EqualSum.find(new int[]{1, 2, 3, 5, 1});
        EqualSum.find(new int[]{1});
        EqualSum.find(new int[]{1, 3});
        EqualSum.find(new int[]{8, 7, 1});
    }

    private static void findFirstInArray() {
        System.out.println("\nFindFirstInArray");
        System.out.println(FindFirstInArray.solve(new int[]{2, 1}));
        System.out.println(FindFirstInArray.solve(new int[]{2, 3}));
        System.out.println(FindFirstInArray.solve(new int[]{2}));
        System.out.println(FindFirstInArray.solve(new int[]{4, 1, 3}));
        System.out.println(FindFirstInArray.solve(new int[]{4, 5, 1, 3}));
        System.out.println(FindFirstInArray.solve(new int[]{6, 1, 3, 5}));
        System.out.println(FindFirstInArray.solve(new int[]{6, 7, 8, 9, 1, 2, 3, 5}));
        System.out.println(FindFirstInArray.solve(new int[]{6, 1, 1}));
        System.out.println(FindFirstInArray.solve(new int[]{6, 1, 1, 1}));
        System.out.println(FindFirstInArray.solve(new int[]{6, 6, 1}));
    }

    private static void prim() {
        System.out.println("\nPrim");
        Prim.solve(new int[][]{
                {0, 7, 0, 5, 0, 0, 0},
                {7, 0, 8, 9, 7, 0, 0},
                {0, 8, 0, 0, 5, 0, 0},
                {5, 9, 0, 0, 15, 6, 0},
                {0, 7, 5, 15, 0, 8, 9},
                {0, 0, 0, 6, 8, 0, 11},
                {0, 0, 0, 0, 9, 11, 0},
        });
    }

    private static void kruskal() {
        System.out.println("\nKruskal");
        Kruskal.solve(new int[][]{
                {0, 7, 0, 5, 0, 0, 0},
                {7, 0, 8, 9, 7, 0, 0},
                {0, 8, 0, 0, 5, 0, 0},
                {5, 9, 0, 0, 15, 6, 0},
                {0, 7, 5, 15, 0, 8, 9},
                {0, 0, 0, 6, 8, 0, 11},
                {0, 0, 0, 0, 9, 11, 0},
        });
    }

    private static void dijkstra() {
        System.out.println("\nDijkstra");
        Dijkstra.solve(new int[][]{
                {0, 7, 9, 0, 0, 14},
                {7, 0, 10, 15, 0, 0},
                {9, 10, 0, 11, 0, 2},
                {0, 15, 11, 0, 6, 0},
                {0, 0, 0, 6, 0, 9},
                {14, 0, 2, 0, 9, 0},
        }, 0);
    }

    private static void binaryTreeWidth() {
        System.out.println("\nBinaryTreeWidth");
        BinaryTreeNode node0 = new BinaryTreeNode();
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        BinaryTreeNode node5 = new BinaryTreeNode();
        node0.data = 0; node1.data = 1; node2.data = 2; node3.data = 3; node4.data = 4; node5.data = 5;
        node0.left = node1; node0.right = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        System.out.println(BinaryTreeWidth.solve(node0));
        BinaryTreeNode node6 = new BinaryTreeNode();
        node2.right = node6;
        System.out.println(BinaryTreeWidth.solve(node0));
    }

    private static void binaryTreeMaxScore() {
        System.out.println("\nBinaryTreeMaxScore");
        BinaryTreeMaxScore.solve(new long[]{5, 7, 1, 2, 10});
        BinaryTreeMaxScore.solve(new long[]{5, 7, 4, 1, 2, 8});
        BinaryTreeMaxScore.solve(new long[]{5, 7});
        BinaryTreeMaxScore.solve(new long[]{5});
    }

    private static void preOrderInOrderToPostOrder() {
        System.out.println("\nPreOrderInOrderToPostOrder");
        System.out.println(PreOrderInOrderToPostOrder.solve("12", "12"));
        System.out.println(PreOrderInOrderToPostOrder.solve("1243", "4213"));
        System.out.println(PreOrderInOrderToPostOrder.solve("1234", "2431"));
        System.out.println(PreOrderInOrderToPostOrder.solve("123456789", "243167598"));
    }

    private static void preOrderPostOrderToInOrder() {
        System.out.println("\nPreOrderPostOrderToInOrder");
        ArrayList<String> result = PreOrderPostOrderToInOrder.solve("", "");
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println();
        result = PreOrderPostOrderToInOrder.solve("1", "1");
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println();
        result = PreOrderPostOrderToInOrder.solve("123", "321");
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println();
        result = PreOrderPostOrderToInOrder.solve("123456", "325641");
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println();
    }

    private static void inOrderPostOrderToPreOrder() {
        System.out.println("\nInOrderPostOrderToPreOrder");
        System.out.println(InOrderPostOrderToPreOrder.solve("123", "132"));
        System.out.println(InOrderPostOrderToPreOrder.solve("12", "21"));
        System.out.println(InOrderPostOrderToPreOrder.solve("21", "21"));
    }

    private static void binarySearch() {
        System.out.println("\nBinarySearch");
        System.out.println(BinarySearch.find(new int[]{1}, 1));
        System.out.println(BinarySearch.find(new int[]{1, 2}, 1));
        System.out.println(BinarySearch.find(new int[]{1, 2, 3}, 3));
        System.out.println(BinarySearch.find(new int[]{1, 2}, 2));
        System.out.println(BinarySearch.find(new int[]{1, 2}, 3));
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
        doublyLinkedList();
        doubleStackBasedCalculator();
        topologicalSort();
        twentyFourGame();
        snakeMatrix();
        missionariesAndCannibalsProblem();
        equalSum();
        findFirstInArray();
        prim();
        kruskal();
        dijkstra();
        binaryTreeWidth();
        binaryTreeMaxScore();
        preOrderInOrderToPostOrder();
        preOrderPostOrderToInOrder();
        inOrderPostOrderToPreOrder();
        binarySearch();
    }
}
