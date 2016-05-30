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

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Xiaofei on 16/5/30.
 *
 * 这个题目高中的时候用DFS做了好久。
 *
 * 现在尝试BFS，二十分钟就写好了，感觉自己现在写代码真的比高中的时候快好多。
 *
 * 做得比较吊的地方是输出的表达式是严格简化过的，不会出现多余括号。
 *
 */
public class TwentyFourGame {

    private static Queue<Node> queue = new LinkedList<>();

    public static void solve(int a, int b, int c, int d) {
        System.out.print(a + " " + b + " " + c + " " + d + ":");
        queue.clear();
        Node node = new Node();
        node.numbers = new int[] {b, c, d};
        node.lastOp = 0;
        node.exp = "" + a;
        node.result = a;
        queue.offer(node);
        node = new Node();
        node.numbers = new int[] {a, c, d};
        node.lastOp = 0;
        node.exp = "" + b;
        node.result = b;
        queue.offer(node);
        node = new Node();
        node.numbers = new int[] {a, b, d};
        node.lastOp = 0;
        node.exp = "" + c;
        node.result = c;
        queue.offer(node);
        node = new Node();
        node.numbers = new int[] {a, b, c};
        node.lastOp = 0;
        node.exp = "" + d;
        node.result = d;
        queue.offer(node);
        boolean flag = false;
        while (!queue.isEmpty()) {
            node = queue.poll();
            int len = node.numbers.length;
            if (len == 0 && Math.abs(node.result - 24) < 0.001) {
                System.out.println(node.exp);
                flag = true;
                break;
            }
            for (int i = 0; i < len; ++i) {
                int[] tmp = new int[len - 1];
                int pos = -1;
                for (int j = 0; j < len; ++j) {
                    if (i != j) {
                        tmp[++pos] = node.numbers[j];
                    }
                }
                Node tmpNode = new Node();
                tmpNode.numbers = tmp;
                tmpNode.result = node.result + node.numbers[i];
                tmpNode.exp = node.exp + "+" + node.numbers[i];
                tmpNode.lastOp = '+';
                queue.offer(tmpNode);

                tmpNode = new Node();
                tmpNode.numbers = tmp;
                tmpNode.result = node.result - node.numbers[i];
                tmpNode.exp = node.exp + "-" + node.numbers[i];
                tmpNode.lastOp = '-';
                queue.offer(tmpNode);

                tmpNode = new Node();
                tmpNode.numbers = tmp;
                tmpNode.result = node.numbers[i] - node.result;
                if (node.lastOp == '-' || node.lastOp == '+') {
                    tmpNode.exp = "" + node.numbers[i] + "-(" + node.exp + ")";
                } else {
                    tmpNode.exp = "" + node.numbers[i] + "-" + node.exp;
                }
                tmpNode.lastOp = '-';
                queue.offer(tmpNode);

                tmpNode = new Node();
                tmpNode.numbers = tmp;
                tmpNode.result = node.numbers[i] * node.result;
                if (node.lastOp == '-' || node.lastOp == '+') {
                    tmpNode.exp = "(" + node.exp + ")*" + node.numbers[i];
                } else {
                    tmpNode.exp = node.exp + "*" + node.numbers[i];
                }
                tmpNode.lastOp = '*';
                queue.offer(tmpNode);

                tmpNode = new Node();
                tmpNode.numbers = tmp;
                tmpNode.result = node.numbers[i] / node.result;
                if (node.lastOp == 0) {
                    tmpNode.exp = "" + node.numbers[i] + "/" + node.exp + "";
                } else {
                    tmpNode.exp = "" + node.numbers[i] + "/(" + node.exp + ")";
                }
                tmpNode.lastOp = '/';
                queue.offer(tmpNode);

                tmpNode = new Node();
                tmpNode.numbers = tmp;
                tmpNode.result = node.result / node.numbers[i];
                if (node.lastOp == '-' || node.lastOp == '+') {
                    tmpNode.exp = "(" + node.exp + ")/" + node.numbers[i];
                } else {
                    tmpNode.exp = node.exp + "/" + node.numbers[i];
                }
                tmpNode.lastOp = '/';
                queue.offer(tmpNode);

            }
        }
        if (!flag) {
            System.out.println("No solution");
        }
    }

    private static class Node {
        int[] numbers;
        double result;
        String exp;
        char lastOp;
    }
}
