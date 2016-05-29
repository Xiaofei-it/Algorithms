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
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Xiaofei on 16/5/29.
 *
 * 今天写个拓扑排序，试试好久不用的邻接表表示图。
 *
 * 下面这个类有点奇葩，其实应该传入一个图，但我不想搞得这么麻烦，毕竟这不是工程。纯粹写算法玩玩。
 *
 */
public class TopologicalSort {
    private ArrayList<Element> nodes;

    //这个要改，效率太低。
    private ArrayList<Integer> incomings;

    public TopologicalSort(int nodeCount) {
        nodes = new ArrayList<>();
        incomings = new ArrayList<>();
        for (int i = 0; i < nodeCount; ++i) {
            nodes.add(new Element(i));
            incomings.add(0);
        }
    }

    public void link(int node1, int node2) {
        nodes.get(node1).add(node2);
        incomings.set(node2, incomings.get(node2) + 1);
    }

    public List<Integer> solve() {
        List<Integer> result = new ArrayList<>();
        while (true) {
            int i;
            int size = incomings.size();
            for (i = 0; i < size; ++i) {
                if (incomings.get(i) == 0) {
                    break;
                }
            }
            if (i == size) {
                break;
            }
            incomings.set(i, -1);
            result.add(i);
            List<Integer> linkedNodes = nodes.get(i).getLinkedNodes();
            size = linkedNodes.size();
            for (i = 0; i < size; ++i) {
                int node = linkedNodes.get(i);
                if (incomings.get(node) != -1) {
                    incomings.set(node, incomings.get(node) - 1);
                }
            }
        }
        return result;
    }

    private static class Element {
        int node;
        List<Integer> linkedNodes = new LinkedList<>();
        Element(int node) {
            this.node = node;
        }
        void add(int node) {
            linkedNodes.add(node);
        }
        List<Integer> getLinkedNodes() {
            return linkedNodes;
        }
    }
}
