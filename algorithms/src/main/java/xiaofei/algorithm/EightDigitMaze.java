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
import java.util.HashSet;

/**
 * Created by Xiaofei on 16/5/26.
 *
 * 八数码问题，也就是九宫格问题。按理说要用A*算法，这个很久以前写过。我以后再写。
 *
 * 今天只是想练练BFS。
 *
 * 这个英文不知道该怎么说，Eight digit maze是我自己瞎写的。
 *
 * 9的9次方，可以用int表示。int是4字节。
 *
 * 如果用其他方式表示，比如一个字节表示两个格，好像都没int省空间。
 *
 * 所以就用int。
 */
public class EightDigitMaze {

    private static int[] dx = new int[]{0, 0, -1, 1};

    private static int[] dy = new int[]{-1, 1, 0, 0};

    private static int arrayToInt(int[][] array) {
        int result = 1;
        for (int i = 0; i < 3; ++i) {
            final int[] subArray = array[i];
            for (int j = 0; j < 3; ++j) {
                result = result * 9 + subArray[j];
            }
        }
        return result;
    }

    private static int[][] intToArray(int x) {
        int[][] result = new int[3][3];
        for (int i = 2; i >= 0; --i) {
            for (int j = 2; j >= 0; --j) {
                result[i][j] = x % 9;
                x /= 9;
            }
        }
        return result;
    }

    private static void output(int x) {
        int[][] array = intToArray(x);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (array[i][j] == 0) {
                    System.out.print(' ');
                } else {
                    System.out.print(array[i][j]);
                }
            }
            System.out.println();
        }
    }

    /**
     *
     * 下面这个函数很长，因为我把所有的东西都放里面了。为什么不变成子函数？因为变成子函数的话很蛋疼。
     *
     * 我这个项目都是算法，不是工程，所以不用管那么多代码风格。
     */
    public static void solve(int[][] source, int[][] dest) {
        class Element {
            int state;
            int last;
            Element(int state) {
                this.state = state;
                this.last = -1;
            }
            Element(int state, int last) {
                this.state = state;
                this.last = last;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        final int sourceInt = arrayToInt(source);
        final int destInt = arrayToInt(dest);
        set.add(sourceInt);
        //如果用Queue，我不知道怎么保存之前的数据，所以这里直接用ArrayList
        ArrayList<Element> queue = new ArrayList<>();
        int head = 0;
        int tail = 1;
        queue.add(new Element(sourceInt));

        while (head < tail) {

            Element element = queue.get(head);

            if (element.state == destInt) {
                //输出结果，退出循环。
                ArrayList<Integer> tmp = new ArrayList<>();
                int index = head;
                while (index != -1) {
                    tmp.add(index);
                    index = queue.get(index).last;
                }
                final int size = tmp.size();
                for (int i = size - 1; i >= 0; --i) {
                    System.out.println("Step " + Integer.toString(size - i));
                    output(queue.get(tmp.get(i)).state);
                }
                break;
            }

            int[][] array = intToArray(element.state);
            boolean flag = false;
            int x = -1, y = -1;
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if (array[i][j] == 0) {
                        flag = true;
                        x = i;
                        y = j;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }

            for (int i = 0; i < 4; ++i) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (0 <= nextX && nextX <= 2 && 0 <= nextY && nextY <= 2) {
                    int tmp = array[nextX][nextY];
                    array[nextX][nextY] = 0;
                    array[x][y] = tmp;
                    int state = arrayToInt(array);
                    if (!set.contains(state)) {
                        queue.add(new Element(state, head));
                        set.add(state);
                        ++tail;
                    }
                    array[nextX][nextY] = tmp;
                    array[x][y] = 0;
                }
            }

            ++head;
        }
    }
}
