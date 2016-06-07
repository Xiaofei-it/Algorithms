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
 * Created by Xiaofei on 16/6/7.
 */
public class BinaryTreeWidth {

    private static Pair solveInternal(BinaryTreeNode node) {
        if (node.left == null && node.right == null) {
            return new Pair(0, 0);
        }
        if (node.left == null) {
            Pair right = solveInternal(node.right);
            return new Pair(
                    right.a - 1 > 0 ? right.a - 1 : 0,
                    right.b + 1);
        }
        if (node.right == null) {
            Pair left = solveInternal(node.left);
            return new Pair(
                    left.a + 1,
                    left.b - 1 > 0 ? left.b - 1 : 0
            );
        }
        Pair left = solveInternal(node.left), right = solveInternal(node.right);
        return new Pair(
                left.a + 1 > right.a - 1 ? left.a + 1 : right.a - 1,
                left.b - 1 > right.b + 1 ? left.b - 1 : right.b + 1);
    }

    public static int solve(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        Pair pair = solveInternal(node);
        return pair.a + pair.b + 1;
    }

    private static class Pair {
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
