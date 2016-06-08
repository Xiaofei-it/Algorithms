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

package xiaofei.algorithm.problem;

/**
 * Created by Xiaofei on 16/6/8.
 *
 * 设一个n个节点的二叉树tree的中序遍历为（l,2,3,…,n），其中数字1,2,3,…,n为节点编号。每个节点都有一个分数（均为正整数），记第i个节点的分数为di，tree及它的每个子树都有一个加分，任一棵子树subtree（也包含tree本身）的加分计算方法如下：

 subtree的左子树的加分× subtree的右子树的加分＋subtree的根的分数

 若某个子树为空，规定其加分为1，叶子的加分就是叶节点本身的分数。不考虑它的空子树。

 试求一棵符合中序遍历为（1,2,3,…,n）且加分最高的二叉树tree。要求输出；

 （1）tree的最高加分

 （2）tree的前序遍历



 【输入格式】

 第1行：一个整数n（n＜30），为节点个数。

 第2行：n个用空格隔开的整数，为每个节点的分数（分数＜100）。



 【输出格式】

 第1行：一个整数，为最高加分（结果不会超过4,000,000,000）。

 第2行：n个用空格隔开的整数，为该树的前序遍历。



 【输入样例】

 5

 5 7 1 2 10



 【输出样例】

 145

 3 1 2 4 5

 f[m, n] =

 if m==n f[m,n] = scores[m]

 if m+1=n f[m,n] = max(f[m,m] + scores[n], f[n,n]+ s[m])

 f[m,n] = max(s[m]+f(m+1,n), f(m,m)+s[m+1],f(m+2,n),...f(m,n-1)+s[n])
 */
public class BinaryTreeMaxScore {

    private static long[][] f;

    private static int[][] g;

    private static void preOrder(int i, int j) {
        if (i > j) {
            return;
        }
        System.out.print(g[i][j] + " ");
        preOrder(i, g[i][j] - 1);
        preOrder(g[i][j] + 1, j);
    }

    public static void solve(long[] scores) {
        int length = scores.length;
        f = new long[length][length];
        g = new int[length][length];
        for (int i = length - 1; i >= 0; --i) {
            for (int j = i; j <= length - 1; ++j) {
                if (i == j) {
                    f[i][j] = scores[i];
                    g[i][j] = i;
                } else {
                    if (scores[i] + f[i + 1][j] > f[i][j - 1] + scores[j]) {
                        f[i][j] = scores[i] + f[i + 1][j];
                        g[i][j] = i;
                    } else {
                        f[i][j] = f[i][j - 1] + scores[j];
                        g[i][j] = j;
                    }
                    for (int k = i; k <= j - 2; ++k) {
                        long tmp = f[i][k] * f[k + 2][j] + scores[k + 1];
                        if (tmp > f[i][j]) {
                            f[i][j] = tmp;
                            g[i][j] = k + 1;
                        }
                    }
                }
            }
        }
        System.out.println(f[0][length - 1]);
        preOrder(0, length - 1);
        System.out.println();
    }
}
