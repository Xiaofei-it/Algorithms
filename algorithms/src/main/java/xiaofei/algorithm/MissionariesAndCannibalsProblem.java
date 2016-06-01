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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xiaofei on 16/6/1.
 *
 * 设有3个传教士（Missionaries）和3个野人(Cannibals)来到河边，打算乘一只船从右岸渡到左岸去。
 * 该船的最大负荷能力为两个人（k=2）。在任何情况下：如果野人人数超过传教士人数，那么野人就会把传教士吃掉。
 * 他们怎样才能用这条船安全地把所有人都渡过河去呢？
 *
 * 网上有人用dfs，这不很明显应该用bfs吗？？？
 *
 * 好忧伤的六一儿童节！！！
 *
 *
 */
public class MissionariesAndCannibalsProblem {

    private static int[] dm = new int[]{0, 0, 1, 1, 2};

    private static int[] dc = new int[]{1, 2, 0, 1, 0};

    public static void solve() {
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(new Node(3, 3, 0, -1));
        int head = 0;
        int tail = 1;
        while (head < tail) {
            Node node = queue.get(head);
            if (node.m == 0 && node.c == 0) {
                break;
            }
            if (node.b == 0) {
                for (int i = 0; i < 5; ++i) {
                    int m1 = node.m - dm[i];
                    int m2 = 3 - m1;
                    int c1 = node.c - dc[i];
                    int c2 = 3 - c1;
                    if (m1 >=0 && m1 <= 3 && c1 >= 0 && c1 <= 3 && (m1 == 0 || m1 >= c1) && (m2 == 0 || m2 >= c2)) {
                        queue.add(new Node(m1, c1, 1, head));
                        ++tail;
                    }
                }
            } else {
                for (int i = 0; i < 5; ++i) {
                    int m1 = node.m + dm[i];
                    int m2 = 3 - m1;
                    int c1 = node.c + dc[i];
                    int c2 = 3 - c1;
                    if (m1 >=0 && m1 <= 3 && c1 >= 0 && c1 <= 3 && (m1 == 0 || m1 >= c1) && (m2 == 0 || m2 >= c2)) {
                        queue.add(new Node(m1, c1, 0, head));
                        ++tail;
                    }
                }
            }
            ++head;
        }
        if (head < tail) {
            List<Node> result = new ArrayList<>();
            int p = head;
            while (p != -1) {
                result.add(queue.get(p));
                p = queue.get(p).last;
            }
            for (int i = result.size() - 1; i >= 0; --i) {
                Node node = result.get(i);
                System.out.println("" + node.m + " " + node.c + " " + node.b);
            }
        }
    }

    private static class Node {
        int m;
        int c;
        int b; //0表示右岸
        int last;
        Node(int m, int c, int b, int last) {
            this.m = m;
            this.c = c;
            this.b = b;
            this.last = last;
        }
    }
}
