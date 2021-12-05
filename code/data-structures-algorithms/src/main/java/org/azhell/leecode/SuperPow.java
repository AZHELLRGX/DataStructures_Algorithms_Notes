package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 372. 超级次方
 * 1、主要是数学知识：欧拉函数、费马降幂  难度极其高
 * 2、快速幂  最终还是选择了这个解法，因为比较简单
 */
public class SuperPow {
    public static void main(String[] args) {
        SuperPow superPow = new SuperPow();
        Utils.print(superPow.superPow(2, new int[]{3}));
        Utils.print(superPow.superPow(2, new int[]{1, 0}));
        Utils.print(superPow.superPow(1, new int[]{4, 3, 3, 8, 5, 2}));
        Utils.print(superPow.superPow(2147483647, new int[]{2, 0, 0}));
        Utils.print(superPow.superPow(78267, new int[]{
                1, 7, 7, 4, 3, 1, 7, 0, 1, 4, 4, 9, 2, 8, 5, 0, 0, 9, 3, 1, 2, 5, 9, 6
        }));
    }

    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }

    private int dfs(int a, int[] b, int index) {
        if (index == -1) return 1;
        // 起始就是把数组各位幂次方后的数据再做10的幂次方
        return qpowModByCycle(dfs(a, b, index - 1), 10) * qpowModByCycle(a, b[index]) % MOD;
    }

    // 快速幂 递归方式
    private int qpowByRecursion(int a, int b) {
        if (b == 0) {
            return 1;
        } else if (b % 2 == 1) {
            // 对于奇数幂
            return qpowByRecursion(a, b - 1) * a;
        } else {
            int temp = qpowByRecursion(a, b / 2);
            return temp * temp;
        }
    }

    // 递归毕竟存在性能损耗，可以使用循环代替
    private int qpowByCycle(int a, int b) {
        int ans = 1;
        while (b > 0) {
            // 当b等于奇数的时候
            if ((b & 1) == 1)
                ans *= a;
            a *= a;
            b >>= 1;
        }
        return ans;
    }

    // 次方计算后取模起始可以在每步取模
    private int qpowModByCycle(int a, int b) {
        int ans = 1;
        a %= MOD;
        while (b > 0) {
            // 当b等于奇数的时候
            if ((b & 1) == 1)
                ans = ans * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return ans;
    }

    /**
     * 函数定义：对于一个正整数n，小于n且和n互质的正整数（包括1）的个数，记作φ(n)
     * 通式：φ(x)=x*(1-1/p1)(1-1/p2)(1-1/p3)*(1-1/p4)…..(1-1/pn)
     * 其中p1, p2……pn为x的所有质因数，x是不为0的整数;φ(1)=1（因为唯一和1互质的数就是1本身）
     * 对于质数p，φ(p) = p - 1; 但是注意φ(1)=1
     * 欧拉定理：对于互质的正整数a和n，有aφ(n) ≡ 1 mod n
     * 欧拉函数是积性函数，因为当m,n互质，φ(mn)=φ(m)φ(n)
     * 若n是质数p的k次幂，φ(n)=p^k-p^(k-1)=(p-1)p^(k-1)，因为除了p的倍数外，其他数都跟n互质
     * 特殊性质：当n为奇数时，φ(2n)=φ(n)
     * 欧拉函数还有这样的性质：设a为N的质因数，若(N % a == 0 && (N / a) % a == 0)
     * 则有E(N)=E(N / a) * a；若(N % a == 0 && (N / a) % a != 0) 则有：E(N) = E(N / a) * (a - 1)
     * <p>
     * 下面代码就是为了求解欧拉函数
     */
    private long ol(long x) {
        long i;
        long res = x;
        for (i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                res = res - res / i;
                while (x % i == 0)
                    x /= i;
            }
        }
        if (x > 1)
            res = res - res / x;
        return res;
    }

    /*
    这是试用第一种方案的解法，参考链接
    对于我目前来说比较难以理解，所以还是留待后续回来学习
    https://leetcode-cn.com/problems/super-pow/solution/jiang-mi-gong-shi-kuai-su-mi-shi-jian-fu-za-du-gan/
     */
    private int superPow1(int a, int[] b) {
        int c = (int) ol(1337);
        int sum = 0;
        for (int j : b) sum = (sum * 10 + j) % c;
        sum += c;
        return q(a, sum, 1337);
    }

    private int q(long x, int y, int M) {
        long res = 1;
        while (y > 0) {
            if (y % 2 > 0)
                res = res % M * x % M;
            x = x % M * x % M;
            y /= 2;
        }
        return (int) res;
    }
}
