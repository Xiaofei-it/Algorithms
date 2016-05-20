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

package xiaofei.algorithm;

/**
 * Created by Xiaofei on 16/5/20.
 */
public class BinarySearchTree {
    private BinaryTreeNode root;
    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        if (root == null) {
            root = new BinaryTreeNode();
            root.data = data;
        } else {
            BinaryTreeNode p = root, q = null;
            while (p != null) {
                q = p;
                if (p.data < data) {
                    p = p.right;
                } else if (p.data > data){
                    p = p.left;
                } else {
                    return;
                }
            }
            p = new BinaryTreeNode();
            p.data = data;
            if (q.data < data) {
                q.right = p;
            } else {
                q.left = p;
            }
        }
    }

    public boolean contains(int data) {
        if (root == null) {
            return false;
        }
        BinaryTreeNode p = root;
        while (p != null) {
            if (p.data < data) {
                p = p.right;
            } else if (p.data > data){
                p = p.left;
            } else {
                return true;
            }
        }
        return false;
    }

    public void delete(int data) {
        if (root == null) {
            return;
        }
        BinaryTreeNode p = root, q = null;
        while (p != null) {
            if (p.data < data) {
                q = p;
                p = p.right;
            } else if (p.data > data){
                q = p;
                p = p.left;
            } else {
                break;
            }
        }
        //element not exist
        if (p == null) {
            return;
        }
        //element is root
        if (p == root) {
            if (p.left == null && p.right == null) {
                root = null;
            } else if (p.left == null) {
                root = p.right;
            } else if (p.right == null) {
                root = p.left;
            } else {
                BinaryTreeNode p1 = p.left, q1 = null;
                while (p1.right != null) {
                    q1 = p1;
                    p1 = p1.right;
                }
                if (q1 != null) {
                    q1.right = p.left;
                }
                p1.left = p.left;
                p1.right = p.right;
                root = p1;
            }
            return;
        }
        if (p.left == null && p.right == null) {
            if (q.data < data) {
                q.right = null;
            } else {
                q.left = null;
            }
        } else if (p.left == null) {
            if (q.data < data) {
                q.right = p.right;
            } else {
                q.left = p.right;
            }
        } else if (p.right == null) {
            if (q.data < data) {
                q.right = p.left;
            } else {
                q.left = p.right;
            }
        } else {
            BinaryTreeNode p1 = p.left, q1 = null;
            while (p1.right != null) {
                q1 = p1;
                p1 = p1.right;
            }
            if (q1 != null) {
                q1.right = p1.left;
            }
            p1.left = p.left;
            p1.right = p.right;
            if (q.data < data) {
                q.right = p1;
            } else {
                q.left = p1;
            }

        }

    }

    public void output() {
        if (root != null) {
            InOrderTraversal.traversalCorecursively(root);
        }
    }
}
