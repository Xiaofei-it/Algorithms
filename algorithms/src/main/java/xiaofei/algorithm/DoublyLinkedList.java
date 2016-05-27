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
 * Created by Xiaofei on 16/5/27.
 */
public class DoublyLinkedList<T> {

    private Node<T> head;

    private Node<T> tail;

    private int size;

    public DoublyLinkedList() {
        head = tail = null;
        size = 0;
    }

    //tested
    public boolean add(T t) {
        if (head == null) {
            head = tail = new Node<T>(t);
        } else {
            Node<T> node = new Node<T>(t, tail);
            tail.next = node;
            tail = node;
        }
        ++size;
        return true;
    }

    //tested
    public int size() {
        return size;
    }

    //tested
    public boolean isEmpty() {
        return size == 0;
    }

    //tested
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    //tested
    public void clear() {
        Node<T> node = head;
        while (node != null) {
            Node<T> tmp = node.next;
            node.prev = null;
            node.next = null;
            node = tmp;
        }
        head = tail = null;
        size = 0;
    }

    //tested
    public T get(int index) {
        return getInternal(index).data;
    }

    private Node<T> getInternal(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index < 0");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = head;
        for (int i = 0; i < index; ++i) {
            node = node.next;
        }
        return node;
    }

    //tested
    public T set(int index, T element) {
        Node<T> node = getInternal(index);
        T prev = node.data;
        node.data = element;
        return prev;
    }

    //tested
    public void add(int index, T element) {
        if (index == size) {
            add(element);
        } else {
            Node<T> node1 = getInternal(index);
            Node<T> node2 = new Node<T>(element, node1.prev, node1);
            if (head == node1) {
                head = node2;
            }
            if (node1.prev != null) {
                node1.prev.next = node2;
            }
            node1.prev = node2;
            ++size;
        }
    }

    //tested
    public T remove(int index) {
        Node<T> node = getInternal(index);
        if (node == head) {
            head = node.next;
        }
        if (node == tail) {
            tail = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        --size;
        return node.data;
    }

    //tested
    public int indexOf(Object o) {
        int result = -1;
        if (head == null) {
            return result;
        }
        Node<T> node = head;
        while (node != null) {
            ++result;
            if (node.data == o) {
                return result;
            }
            node = node.next;
        }
        return -1;
    }

    /*public T[] reversedArray() {
        T[] result = (T[]) new Object[size];
        Node<T> node = tail;
        int pos = 0;
        while (node != null) {
            result[pos++] = node.data;
            node = node.prev;
        }
        return result;
    }*/

    public List<T> reversedArray() {
        List<T> result = new ArrayList<>();
        Node<T> node = tail;
        while (node != null) {
            result.add(node.data);
            node = node.prev;
        }
        return result;
    }

    private static class Node<T> {

        T data;

        Node<T> prev;

        Node<T> next;

        Node(T data) {
            this(data, null, null);
        }

        Node(T data, Node<T> prev) {
            this(data, prev, null);
        }

        Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

}
