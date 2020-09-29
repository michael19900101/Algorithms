package com.aotuman.labuladong.dp;

import java.util.HashMap;
import java.util.Map;

public class Fib {

    /*****************暴力递归*****************************/
    /*****************时间复杂度：O(2^N) 空间复杂度：O(N)*****************************/
    public int fib0(int N) {
        if (N <= 1) {
            return N;
        }
        return fib0(N-1) + fib0(N-2);
    }

    /*****************备忘录 自顶向下*****************************/
    /*****************时间复杂度：O(N) 空间复杂度：O(N)*****************************/
    /**
     * 我们先计算存储子问题的答案，然后利用子问题的答案计算当前斐波那契数的答案。
     * 我们将递归计算，但是通过记忆化不重复计算已计算的值
     */
    int fib(int N) {
        if (N < 1) return 0;
        // 备忘录
        Map<Integer, Integer> map = new HashMap<>();
        // 进行带备忘录的递归
        return helper(map, N);
    }

    Integer helper(Map<Integer, Integer> memo, Integer n) {
        // base case
        if (n == 1 || n == 2) return 1;
        // 已经计算过
        if (memo.get(n) != null) return memo.get(n);
        int result = helper(memo, n - 1) + helper(memo, n - 2);
        memo.put(n, result);
        return memo.get(n);
    }

    /*******************dp table 自底向上***************************/
    /*****************时间复杂度：O(N) 空间复杂度：O(N)*****************************/
    /**
     * 自底向上通过迭代计算斐波那契数的子问题并存储已计算的值，通过已计算的值进行计算。减少递归带来的重复计算。
     */
    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        return memoize(N);
    }

    public int memoize(int N) {
        int[] cache = new int[N + 1];
        cache[1] = 1;

        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[N];
    }

    /*****************自底向上进行迭代 「状态压缩」*****************************/
    /*****************时间复杂度：O(N) 空间复杂度：O(1) 仅仅使用了 current，prev1，prev2********************/
    public int fib3(int N) {
        if (N <= 1) {
            return N;
        }
        if (N == 2) {
            return 1;
        }

        int current = 0;
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 3; i <= N; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }

    public static void main(String[] args) {
        Fib f = new Fib();
        int result = f.fib(6);
        System.out.println(result);
    }
}
