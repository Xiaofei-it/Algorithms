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
 * Created by Xiaofei on 16/5/25.
 *
 * I write something is the recursive sort. It is my own understanding, the correctness of which cannot be guaranteed.
 *
 */
public class QuickSort {

    private static int[] array;
    private static void sortRecursively(int l, int r) {
        int i = l, j = r;
        int m = array[(l + r) / 2];
        do {
            while (array[i] < m) {
                ++i;
            }
            while (m < array[j]) {
                --j;
            }
            /**
             * Here we can guarantee that
             * for all x <= i ==> a[x] <= m
             * for all j <= x ==> m <= a[x]
             *
             * If both of i and j reach the index of m, then i == j.
             *
             * When i > j? If i ==j and a[i] < m, then here i will be larger than j.
             *
             */
            if (i <= j) {
                /**
                 * When i == j, the swap is useless.
                 */
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                ++i;
                --j;
            }
            /**
             * If i == j, then it goes into the next loop. It surely will jump out since it will go
             * into the "if" clause.
             *
             * Here if i == j, we can NOT let it jump out.
             * Because a[i] will be sorted in both of the following sort!!!
             */
        } while (i <= j);
        if (l < j) {
            sortRecursively(l, j);
        }
        if (i < r) {
            sortRecursively(i, r);
        }
    }

    private static void sortCorecursively(int l, int r) {
        class Element {
            int l;
            int r;
            int i;
            int state;
            //这里用state表示通用状态，和之前非递归代码风格不一样。
            Element(int l, int r) {
                this.l = l;
                this.r = r;
                this.i = -1;
                this.state = 0;
            }
        }
        Stack<Element> stack = new Stack<>();
        stack.push(new Element(l, r));
        while (!stack.isEmpty()) {
            Element element = stack.peek();
            if (element.state == 0) {
                int i = element.l, j = element.r, m = array[(i + j) / 2];
                do {
                    while (array[i] < m) {
                        ++i;
                    }
                    while (m < array[j]) {
                        --j;
                    }
                    if (i <= j) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        ++i;
                        --j;
                    }
                } while (i <= j);
                element.i = i;
                if (element.l < j) {
                    stack.push(new Element(element.l, j));
                }
                element.state = 1;
            } else if (element.state == 1) {
                if (element.i < element.r) {
                    stack.push(new Element(element.i, element.r));
                }
                element.state = 2;
            } else if (element.state == 2) {
                stack.pop();
            }
        }
    }

    public static void sort(int[] array, boolean recursive) {
        QuickSort.array = array;
        if (recursive) {
            sortRecursively(0, array.length - 1);
        } else {
            sortCorecursively(0, array.length - 1);
        }
    }

}
