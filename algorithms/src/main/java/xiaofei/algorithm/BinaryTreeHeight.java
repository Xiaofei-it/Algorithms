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

import java.util.Stack;

/**
 * Created by Xiaofei on 16/5/21.
 *
 * I am writing code in Starbucks alone.
 *
 * What a sad picture!!!
 *
 * I cannot remember when I drank coffee with somebody else last time.
 *
 */
public class BinaryTreeHeight {

    public static int calculateRecursively(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(calculateRecursively(root.left), calculateRecursively(root.right)) + 1;
        }
    }

    public static int calculateCorecursively(BinaryTreeNode root) {
        //当年ACM的时候总喜欢自己写queue或者stack，几乎不用C++的STL库。现在想用一下Java的Stack
        class Element {
            BinaryTreeNode node;
            int left;
            int right;
            Element(BinaryTreeNode node) {
                this.node = node;
                left = right = -1;
            }
        }
        Stack<Element> stack = new Stack<>();
        stack.push(new Element(root));
        int result = -1;
        while (!stack.empty()) {
            Element element = stack.peek();
            if (element.node == null) {
                stack.pop();
                if (stack.isEmpty()) {
                    result = 0;
                } else {
                    Element tmp = stack.peek();
                    if (tmp.left == -1) {
                        tmp.left = 0;
                    } else {
                        tmp.right = 0;
                    }
                }
            } else if (element.left == -1) {
                stack.push(new Element(element.node.left));
            } else if (element.right == -1) {
                stack.push(new Element(element.node.right));
            } else {
                Element tmp1 = stack.pop();
                int height = Math.max(tmp1.left, tmp1.right) + 1;
                if (stack.isEmpty()) {
                    result = height;
                } else {
                    Element tmp2 = stack.peek();
                    if (tmp2.left == -1) {
                        tmp2.left = height;
                    } else {
                        tmp2.right = height;
                    }
                }
            }
        }
        return result;
    }
}
