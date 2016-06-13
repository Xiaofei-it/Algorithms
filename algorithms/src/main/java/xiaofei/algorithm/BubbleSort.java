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

import java.util.Comparator;

/**
 * Created by Xiaofei on 16/6/13.
 */
public class BubbleSort {

    public static <T> void sort(T[] a, Comparator<T> comparator) {
        int length = a.length;
        for (int i = 0; i < length - 1; ++i) {
            boolean flag = false;
            for (int j = length - 1; j > i; --j) {
                if (comparator.compare(a[j - 1], a[j]) > 0) {
                    T tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
