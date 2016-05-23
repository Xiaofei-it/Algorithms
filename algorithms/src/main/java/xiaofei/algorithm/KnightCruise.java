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
 * Created by Xiaofei on 16/5/23.
 */
public class KnightCruise {

    //8好像特别慢，我考虑剪枝，但状态太多，64的64次方，加上节点位置，不知道怎么剪。我记得原来用Pascal都没这么慢啊。
    private static final int SIZE = 6;

    private static int[][] board = new int[SIZE][SIZE];

    private static int[] dx = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};

    private static int[] dy = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};

    private static void clear() {
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                board[i][j] = 0;
            }
        }
    }

    private static void output() {
        System.out.println();
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                if (board[i][j] < 10) {
                    System.out.print("  " + board[i][j]);
                } else {
                    System.out.print(" " + board[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static boolean solveRecursively(int x, int y, int step) {
        if (step == SIZE * SIZE) {
            output();
            return true;
        }
        for (int i = 0; i < 8; ++i) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < SIZE && nextY >=0 && nextY < SIZE && board[nextX][nextY] == 0) {
                board[nextX][nextY] = step + 1;
                if (solveRecursively(nextX, nextY, step + 1)) {
                    return true;
                } else {
                    board[nextX][nextY] = 0;
                }
            }
        }
        return false;
    }

    private static void solveCorecursively(int x, int y) {
        class Element {
            int x;
            int y;
            int step;
            int index;
            Element(int x, int y, int step) {
                this.x = x;
                this.y = y;
                this.step = step;
                this.index = -1;
            }
        }
        Stack<Element> stack = new Stack<>();
        stack.push(new Element(x, y, 1));
        board[x][y] = 1;
        while (!stack.isEmpty()) {
            Element element = stack.peek();
            if (element.step == SIZE * SIZE) {
                output();
                return;
            } else {
                int nextX, nextY;
                if (element.index >= 0) {
                    nextX = element.x + dx[element.index];
                    nextY = element.y + dy[element.index];
                    board[nextX][nextY] = 0;
                }
                while (++element.index < 8) {
                    nextX = element.x + dx[element.index];
                    nextY = element.y + dy[element.index];
                    if (nextX >= 0 && nextX < SIZE && nextY >= 0 && nextY < SIZE && board[nextX][nextY] == 0) {
                        board[nextX][nextY] = element.step + 1;
                        stack.push(new Element(nextX, nextY, element.step + 1));
                        break;
                    }
                }
                if (element.index == 8) {
                    stack.pop();
                }
            }
        }
    }

    public static void solve(boolean recursive) {
        if (recursive) {
            clear();
            board[0][0] = 1;
            solveRecursively(0, 0, 1);
        } else {
            clear();
            solveCorecursively(0, 0);
        }
    }
}
