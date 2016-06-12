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
 * Created by Xiaofei on 16/6/12.
 *
 *
 */
public class InOrderPostOrderToPreOrder {

    public static String solve(String inOrder, String postOrder) {
        if (inOrder.length() == 0) {
            return "";
        }
        int length = inOrder.length();
        char root = postOrder.charAt(length - 1);
        int pos = inOrder.indexOf(root);
        return Character.toString(root)
                + solve(inOrder.substring(0, pos), postOrder.substring(0, pos))
                + solve(inOrder.substring(pos + 1), postOrder.substring(pos, length - 1));
    }
}
