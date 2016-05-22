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

import java.util.HashMap;

/**
 * Created by Xiaofei on 16/5/22.
 */
public class DisjointSet<T> {
    private HashMap<T, Node<T>> map = new HashMap<>();

    public DisjointSet() {

    }

    public void makeSet(T data) {
        if (map.containsKey(data)) {
            return;
        }
        map.put(data, new Node<T>(data));
    }

    private Node<T> findInternal(Node<T> node) {
        if (node.parent != node) {
            node.parent = findInternal(node.parent);
        }
        return node.parent;
    }

    public T find(T data) {
        Node<T> node = map.get(data);
        if (node == null) {
            return null;
        }
        return findInternal(node).data;
    }

    public void union(T data1, T data2) {
        Node<T> node1 = map.get(data1), node2 = map.get(data2);
        if (node1 == null || node2 == null) {
            return;
        }
        node1 = findInternal(node1);
        node2 = findInternal(node2);
        if (node1.rank < node2.rank) {
            node1.parent = node2;
        } else if (node1.rank > node2.rank) {
            node2.parent = node1;
        } else {
            node1.parent = node2;
            ++node2.rank;
        }
    }

    private static class Node<T> {

        T data;

        Node<T> parent;

        //rank is not depth!!!
        int rank;

        Node(T data) {
            this.data = data;
            this.parent = this;
            this.rank = 0;
        }
    }
}
