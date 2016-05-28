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
 * Created by Xiaofei on 16/5/28.
 *
 * 我又在星巴克一个人写代码了，五月周末都是这么过来的，好忧伤。
 *
 * 双栈计算器是一个很常见的算法题，第一次接触是在2004年。记得华为校园招聘的时候，也出现了同样的上机题。
 *
 * 我当时看时间充裕，就蛋疼地写了一个编译器来求解，最搞笑的是四个上机题，我每个题目都是没编译，写好代码后直接上传，居然每个题目都是直接AC。
 *
 * 感觉特别厉害，然后并没有什么卵用。
 *
 * 华为上机并不是acm，他妈的没有罚时，所以做题速度不影响得分。几次提交之后AC也不影响得分。
 *
 * 算了，直接进入正题。我其实都忘了这个题目用双栈要怎么解决了。现场分析一下，顺便看看我的思路怎么样。
 *
 * 2004年的时候这题目解决的方法是给运算符定义优先级，然后看优先级pop。细节全忘了，好像最后要有一个特殊字符。
 *
 * 现在这样想。
 * 如果是加减号，pop之前的加减乘除号，直到前括号。
 * 如果是乘除号，pop之前的乘除号，直到碰到加减号。
 * 如果是前括号，直接push。
 * 如果是后括号，那么pop直到前括号。
 *
 * 进一步细化
 * 如果是加减号，pop之前的加减乘除号，直到前括号和空。
 * 如果是乘除号，pop之前的乘除号，直到碰到加减号和前括号和空。
 * 如果是前括号，直接push。
 * 如果是后括号，那么pop直到前括号。
 *
 * 这他妈的怎么定义优先级？？？
 * 算了，直接if判断吧
 *
 *
 */
public class DoubleStackBasedCalculator {

    private static Stack<Integer> numberStack = new Stack<>();

    private static Stack<Character> operatorStack = new Stack<>();

    private static int pos;

    private static int type;

    private static String input;

    private static Wrapper getNext() {
        int length = input.length();
        int number = 0;
        while (pos < length) {
            char ch = input.charAt(pos);
            if ('0' <= ch && ch <= '9') {
                if (type == 2) {
                    type = 1;
                    number = 0;
                }
                number = number * 10 + ch - '0';
                ++pos;
            } else {
                if (type == 1) {
                    type = 2;
                    return new Wrapper(number);
                } else {
                    ++pos;
                    return new Wrapper(ch);
                }
            }
        }
        return null;
    }

    private static int solveInternal() {
        Wrapper wrapper;
        while (true) {
            wrapper = getNext();
            if (wrapper.type == 1) {
                numberStack.push(wrapper.number);
            } else if (wrapper.operator != '#') {
                if (wrapper.operator == '+' || wrapper.operator == '-') {
                    char ch;
                    while (!operatorStack.isEmpty() && (operatorStack.peek()) != '(') {
                        ch = operatorStack.pop();
                        if (ch == '+') {
                            numberStack.push(numberStack.pop() + numberStack.pop());
                        } else if (ch == '-') {
                            numberStack.push(-numberStack.pop() + numberStack.pop());
                        } else if (ch == '*') {
                            numberStack.push(numberStack.pop() * numberStack.pop());
                        } else {
                            int n1 = numberStack.pop(), n2 = numberStack.pop();
                            numberStack.push(n2 / n1);
                        }
                    }
                    operatorStack.push(wrapper.operator);
                } else if (wrapper.operator == '*' || wrapper.operator == '/') {
                    char ch;
                    while (!operatorStack.isEmpty() && ((ch = operatorStack.peek()) == '*' || ch == '/')) {
                        ch = operatorStack.pop();
                        if (ch == '*') {
                            numberStack.push(numberStack.pop() * numberStack.pop());
                        } else {
                            int n1 = numberStack.pop(), n2 = numberStack.pop();
                            numberStack.push(n2 / n1);
                        }
                    }
                    operatorStack.push(wrapper.operator);
                } else if (wrapper.operator == '(') {
                    operatorStack.push(wrapper.operator);
                } else if (wrapper.operator == ')') {
                    char ch;
                    while ((ch = operatorStack.pop()) != '(') {
                        if (ch == '+') {
                            numberStack.push(numberStack.pop() + numberStack.pop());
                        } else if (ch == '-') {
                            numberStack.push(-numberStack.pop() + numberStack.pop());
                        } else if (ch == '*') {
                            numberStack.push(numberStack.pop() * numberStack.pop());
                        } else {
                            int n1 = numberStack.pop(), n2 = numberStack.pop();
                            numberStack.push(n2 / n1);
                        }
                    }
                }
            } else {
                char ch;
                while (!operatorStack.isEmpty()) {
                    ch = operatorStack.pop();
                    if (ch == '+') {
                        numberStack.push(numberStack.pop() + numberStack.pop());
                    } else if (ch == '-') {
                        numberStack.push(-numberStack.pop() + numberStack.pop());
                    } else if (ch == '*') {
                        numberStack.push(numberStack.pop() * numberStack.pop());
                    } else {
                        int n1 = numberStack.pop(), n2 = numberStack.pop();
                        numberStack.push(n2 / n1);
                    }
                }
                break;
            }
        }
        return numberStack.pop();
    }

    public static int solve(String input) {
        numberStack.clear();
        operatorStack.clear();
        pos = 0;
        type = 2;
        DoubleStackBasedCalculator.input = input + "#";
        return solveInternal();
    }

    private static class Wrapper {
        int type;
        int number;
        char operator;
        Wrapper(int number) {
            type = 1;
            this.number = number;
            operator = ' ';
        }
        Wrapper(char operator) {
            type = 2;
            number = 0;
            this.operator = operator;
        }

    }
}
