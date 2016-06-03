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
 * Created by Xiaofei on 16/6/3.
 */
public class FindFirstInArray {

    /**
     * 345612
     * 561234
     * 123456
     * @param arr
     */
    public static int solve(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int mid;
        while (i <= j) {
            mid = (i + j) / 2;
            if (arr[i] <= arr[mid] && arr[mid] <= arr[j]) {
                return i;
            } else if (arr[i] <= arr[mid] && arr[mid] >= arr[j]) {
                i = mid + 1;
            } else if (arr[i] >= arr[mid] && arr[mid] <= arr[j]) {
                j = mid;
            } else {
                throw new IllegalStateException();
            }
        }
        throw new IllegalStateException();
    }

}
