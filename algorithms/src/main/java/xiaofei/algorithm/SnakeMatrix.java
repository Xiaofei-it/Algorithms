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
 * Created by Xiaofei on 16/5/31.
 *
 * 今天自虐一番，刚学编程的时候，老师让我们写过各种矩阵。比如
 *
 * 01 02 03 04
 * 12 13 14 05
 * 11 16 15 06
 * 10 09 08 07
 *
 * 当时是用模拟法写的。
 *
 * 我就给这个取名Snake matrix吧，瞎取的。
 *
 * 今天想写一个数学公式，给定i和j，直接得出结果。
 *
 * 看了半天发现规律：
 *
 * 斜对角线的数字比较容易给出，这样的话，这个点属于的那个圈就都可以确定了。
 *
 * 在8*8的矩阵中，
 *
 * (0, 0) => 1
 * (1, 1) => 7*4+1
 * (2, 2) => 7*4+5*4+1
 * (3, 3) => 7*4+5*4+3*4+1
 *
 * 所以在n*n的矩阵中，for all 0<=i<=(n-1)/2，(i, i)是
 * (n-1)*4+(n-3)*4+...+(n-i*2+1)*4+1 = (n-1+n-2i+1)*i/2*4+1 = 4i(n-i)+1
 *
 * 然后通过i和j找到对应的那圈的基准点。
 *
 * 现在开始：
 * 比如n=8
 * 现在确定了(2,2)，设为(k, k). 那么上面那圈是49 50 51 52，i和j满足i=k && k<=j<=n-k-1，对应是4k(n-k)+1+j-k
 * 右边那圈j=n-k-1 && k<=i<=n-k-1，对应是4k(n-k)+1+n-k-1-k+i-k=4k(n-k)+n-3k+i
 * 下面那圈i=n-k-1 && k<=j<=n-k-1，对应是4k(n-k)+n-3k+(n-k-1)+(n-k-1-j)=4k(n-k)+3n-5k-2-j
 * 左边那圈k<i<=n-k-1 && j=k，对应是4k(n-k)+3n-5k-2-k+(n-k-1-i)=4k(n-k)+4n-7k-3-i
 *
 * 所以问题是如何确定k?
 * 如果i<j<=n-i-1，那么k=i
 * 如果n-j-1<=i<=j，那么k=n-j-1
 * 如果n-i-1<=j<=i，那么k=n-i-1
 * 如果j<i<=n-j-1，那么k=j
 *
 * 改进：
 * 如果i<j<=n-i-1，那么k=i
 * 如果n-j-1<i<=j，那么k=n-j-1
 * 如果n-i-1<=j<i，那么k=n-i-1
 * 如果j<i<n-j-1，那么k=j
 *
 */
public class SnakeMatrix {

    private static int getK(int n, int i, int j) {
        if (i <= j && j <= n - i - 1) {
            return i;
        } else if (n - j - 1 < i && i <= j) {
            return n - j - 1;
        } else if (n - i - 1 <= j && j < i) {
            return n - i - 1;
        } else if (j < i && i < n - j - 1) {
            return j;
        }
        throw new IllegalStateException();
    }

    private static int getV(int n, int k, int i, int j) {
        if (i == k && k <= j && j <= n - k - 1) {
            return 4 * k * (n - k) + 1 + j -k;
        } else if (j == n - k - 1 && k <= i && i <= n - k - 1) {
            return 4 * k * (n - k) + n - 3 * k + i;
        } else if (i == n - k - 1 && k <= j && j <= n - k - 1) {
            return 4 * k * (n - k) + 3 * n - 5 * k - 2 - j;
        } else if (k < i && i <= n - k - 1 && j == k) {
            return 4 * k * (n - k) + 4 * n - 7 * k - 3 - i;
        }
        throw new IllegalArgumentException();
    }

    public static void solve(int n) {
        System.out.println();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int k = getK(n, i, j);
                int v = getV(n, k, i, j);
                if (v <= 9) {
                    System.out.print(" 0" + v);
                } else {
                    System.out.print(" " + v);
                }
            }
            System.out.println();
        }
    }
}
