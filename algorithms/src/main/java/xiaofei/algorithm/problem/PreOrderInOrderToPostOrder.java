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
 * 自己出一个题：前序遍历和中序遍历，得到后序遍历
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
