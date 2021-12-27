package org.azhell.leecode;

import org.azhell.tool.Utils;

/**
 * 96. 不同的二叉搜索树
 * 结题思路：
 * 假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，
 * n为根节点，当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，
 * 同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，
 * 所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
 * <p>
 * 状态转义方程得出，即可使用动态规划解题
 * G(0) = 1 // 只是为了计算，并不存在节点为0的二叉搜索树
 * G(1) = 1
 */
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
        Utils.print(u.numTrees(1));
        Utils.print(u.numTrees(2));
        Utils.print(u.numTrees(3));
        Utils.print(u.numTrees(4));
        Utils.print(u.numTrees(19));
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        // 初始量
        dp[0] = 1;
        dp[1] = 1;
        int i = 2;
        while (i <= n) {
            // 套用转移方程
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
            i++;
        }
        return dp[n];
    }
}
