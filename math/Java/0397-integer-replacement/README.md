# 参考资料：
+ https://segmentfault.com/a/1190000007318944
+ http://massivealgorithms.blogspot.com/2016/09/leetcode-397-integer-replacement.html

当 n 为偶数时，下一次迭代 n 的取值确定为 n / 2；
当 n 为奇数时，下一次迭代 n 的取值 n + 1 或者 n - 1，由其二进制表示中的最低两位数决定：
若 n 的最低两位数为 01，则令 n = n - 1
否则，若 n 的最低两位数为 11，则令 n = n + 1
这样处理是为了使 n 的二进制表式中 1 的数目尽可能少，从而减少迭代次数。