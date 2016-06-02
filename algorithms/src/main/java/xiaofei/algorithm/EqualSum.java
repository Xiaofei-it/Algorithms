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

/**
 * Created by Xiaofei on 16/6/2.
 */
public class EqualSum {

    public static void find(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; ++i) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
        int i = 0;
        int j = length - 1;
        int s1 = arr[i];
        int s2 = arr[j];
        while (i < length && j >= 0) {
            if (s1 == s2) {
                System.out.println("i = " + i + " j = " + j);
                ++i;
                --j;
                if (i == length || j == -1) {
                    break;
                }
                s1 += arr[i];
                s2 += arr[j];
            } else if (s1 < s2) {
                ++i;
                if (i == length) {
                    break;
                }
                s1 += arr[i];
            } else {
                --j;
                if (j == -1) {
                    break;
                }
                s2 += arr[j];
            }
        }
    }
}
