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
 *
 * 今天把明天的代码写了吧。
 */
public class AckermannFunction {

    public static long calculateRecursively(long m, long n) {
        if (m == 0) {
            return n + 1;
        } else if (m > 0 && n == 0) {
            return calculateRecursively(m - 1, 1);
        } else if (m > 0 && n > 0) {
            return calculateRecursively(m - 1, calculateRecursively(m, n - 1));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static long calculateCorecursively(long m, long n) {
        class Element {
            long m;
            long n;
            long r;
            Element(long m, long n) {
                this.m = m;
                this.n = n;
                this.r = -1;
            }
        }
        Stack<Element> stack = new Stack<>();
        stack.push(new Element(m, n));
        long tmp = -1;
        while (!stack.isEmpty()) {
            Element element = stack.peek();
            if (element.m == 0) {
                tmp = element.n + 1;
                stack.pop();
            } else if (element.m > 0 && element.n == 0) {
                if (tmp >= 0) {
                    stack.pop();
                } else {
                    stack.push(new Element(element.m - 1, 1));
                }
            } else {
                if (element.r < 0) {
                    if (tmp >= 0) {
                        element.r = tmp;
                        tmp = -1;
                        stack.push(new Element(element.m - 1, element.r));
                    } else {
                        stack.push(new Element(element.m, element.n - 1));
                    }
                } else {
                    if (tmp >= 0) {
                        stack.pop();
                    } else {
                        throw new IllegalStateException();
                    }
                }
            }
        }
        return tmp;
    }
}
