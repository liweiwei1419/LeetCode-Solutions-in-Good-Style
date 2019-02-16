# 参考资料1：https://my.oschina.net/Tsybius2014/blog/497645
# 参考资料2：http://www.cnblogs.com/grandyang/p/4741028.html


class Solution:
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        if num < 10:
            return num

        return 1 + (num - 1) % 9


if __name__ == '__main__':
    print(-1 % 9)  # 返回 8
