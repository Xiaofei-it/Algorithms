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

package xiaofei.algorithm.problem;

import java.util.ArrayList;

/**
 * Created by Xiaofei on 16/6/9.
 *
 * 把明天的代码写了
 *
 *
 */
public class PreOrderPostOrderToInOrder {

    private static ArrayList<String> times(ArrayList<String> a1, ArrayList<String> a2, char ch) {
        ArrayList<String> result = new ArrayList<>();
        for (String s1 : a1) {
            for (String s2 : a2) {
                result.add(s1 + Character.toString(ch) + s2);
            }
        }
        return result;
    }

    public static ArrayList<String> solve(String preOrder, String postOrder) {
        ArrayList<String> result = new ArrayList<>();
        if (preOrder.length() == 0) {
            result.add("");
            return result;
        }
        if (preOrder.length() == 1) {
            result.add(preOrder);
            return result;
        }
        char root = preOrder.charAt(0);
        char child = preOrder.charAt(1);
        int pos = postOrder.indexOf(child);
        int length = preOrder.length();
        if (pos == length - 2) {
            ArrayList<String> tmp = solve(preOrder.substring(1), postOrder.substring(0, length - 1));
            ArrayList<String> empty = new ArrayList<>();
            empty.add("");
            result.addAll(times(empty, tmp, root));
            result.addAll(times(tmp, empty, root));
            return result;
        }
        ArrayList<String> left = solve(preOrder.substring(1, pos + 2), postOrder.substring(0, pos + 1));
        ArrayList<String> right = solve(preOrder.substring(pos + 2), postOrder.substring(pos + 1, length - 1));
        result.addAll(times(left, right, root));
        return result;
    }
}
