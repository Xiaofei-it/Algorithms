package xiaofei.algorithm;

/**
 * Created by Xiaofei on 16/5/19.
 */
public class EightQueensPuzzle {

    /**
     * 八皇后（回溯法）
     * pos[n]
     * 竖排：值相同
     * 左上到右下：i - j = pos[i] - pos[j]  -->  i - pos[i] = j - pos[j]
     * 左下到右上：i - j = pos[j] - pos[i]  -->  i + pos[i] = j + pos[j]
     *
     * 每次都要O(n^2)判断有点蛋疼，不知道有没有优化方案。
     * 现在自己优化一下：
     * hash判断
     * 竖排：hash[SIZE]
     * 左上到右下：i - pos[i] = j - pos[j] 从-(SIZE-1)到(SIZE-1) 为了从0开始，偏移(SIZE-1)
     * 左下到右上：i + pos[i] = j + pos[j] 从0到2*(SIZE-1)
     */

    private static final int SIZE = 8;

    private static int number = 0;

    private static void print(int[] pos) {
        System.out.println(++number);
        int length = pos.length;
        for (int i = 0; i < length; ++i) {
            System.out.print(" " + pos[i]);
        }
        System.out.println();
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < pos[i]; ++j) {
                System.out.print('+');
            }
            System.out.print('*');
            for (int j = pos[i] + 1; j < SIZE; ++j) {
                System.out.print('+');
            }
            System.out.println();
        }
    }

    public static void calculate() {
        int[] pos = new int[SIZE];
        boolean[] hash1 = new boolean[SIZE];
        boolean[] hash2 = new boolean[SIZE * 2 + 1];
        boolean[] hash3 = new boolean[SIZE * 2 + 1];
        int last = 0;
        pos[last] = -1;
        while (last >= 0) {
            if (last == SIZE) {
                print(pos);
                --last;
            } else {
                boolean flag = false;
                if (pos[last] >= 0) {
                    hash1[pos[last]] = false;
                    hash2[last - pos[last] + SIZE - 1] = false;
                    hash3[last + pos[last]] = false;
                }
                while (pos[last] < SIZE - 1) {
                    ++pos[last];
                    if (!hash1[pos[last]] && !hash2[last - pos[last] + SIZE - 1] && !hash3[last + pos[last]]) {
                        hash1[pos[last]] = true;
                        hash2[last - pos[last] + SIZE - 1] = true;
                        hash3[last + pos[last]] = true;
                        ++last;
                        if (last < SIZE) {
                            pos[last] = -1;
                        }
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    --last;
                }
            }
        }
    }
}
