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

/**
 * Created by Xiaofei on 16/6/9.
 *
 * 现在脑子里好乱，要做的事情好多，要学的东西好多，工作上一堆事。真的好烦。
 *
 * 好烦好烦好烦。
 *
 * Fucking mess!!!
 *
 */
public class PreOrderInOrderToPostOrder {

    public static String solve(String preOrder, String inOrder) {
        if (preOrder.length() == 0) {
            return "";
        }
        char root = preOrder.charAt(0);
        int pos = inOrder.indexOf(root);
        return solve(preOrder.substring(1, pos + 1), inOrder.substring(0, pos))
                + solve(preOrder.substring(pos + 1), inOrder.substring(pos + 1))
                + Character.toString(root);
    }
}
