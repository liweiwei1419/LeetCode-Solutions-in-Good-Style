# LeetCode-Solutions-in-Good-Style

大家好，这里是一个算法学习的小教程。可以帮助新手朋友们入门「算法与数据结构」。

+ 特别感谢 [@AbbyDeng](https://github.com/AbbyDeng) 同学的更名建议。

+ 本项目是我在学习《算法与数据结构》的时候，在 [LeetCode（力扣）](https://leetcode-cn.com/) 上做的练习 ；刷题以 Java 语言为主，Python 和 C++ 语言实现为辅；
+ 本项目可以认为是一个《算法与数据结构》的简易教程，适用于零基础和转行的同学；
+ 适用于准备算法面试，不适合于准备算法竞赛；
+ 所有的代码都通过  [LeetCode（力扣）](https://leetcode-cn.com/) 在线测评系统检测；
+ 建议您安装 [Octotree 插件](https://www.octotree.io/?utm_source=lite&utm_medium=extension)，以获得最佳的阅读体验。

![Octotree 插件](http://liweiwei1419.gitee.io/visualgo/github/octotree.png)

可以叫我 weiwei，在我力所能及且时间允许的情况下，我会尽可能回答我知道的问题。如果有不能及时回复的问题，可能是因为我没有看到站内通知，可以发邮件给我 liweiwei1419@gmail.com 。

我的个人网站和算法学习笔记。

+ 个人主页：https://liweiwei1419.gitee.io/leetcode-algo/
+ 语雀笔记：https://www.yuque.com/liweiwei1419/algo
+ CSDN 博客：https://blog.csdn.net/lw_power
+ 微信公众号：（佛系运营，可能没有多少干货）。

![](https://liweiwei1419.gitee.io/visualgo/author/qrcode_for_gh_246ffacb3679_258.jpg)

讲解如有错误，欢迎指正！

我的 LeetBook 是收费教程，投入精力与平时写题解是一样的，只不过 LeetBook 在制作图表上会更细致一点，并且有「力扣」的工作人员和高手参与制作和审核。不排除平时写的题解知识点比 LeetBook 还要多的情况。

# 微信群与 QQ 群

以下原来是写在「力扣」主页里的，由于要配合「力扣」的工作，因此写在了这里。

如果需要一起刷题的朋友，可以加入微信群和 QQ 群。

| 微信群                                                       | QQ 群           |
| ------------------------------------------------------------ | --------------- |
| 每日一题打卡活动和加入微信群可以点 [这里](https://ojeveryday.com/#/check) 。 | 群号：812791932 |

感谢负雪明烛和二哥组织建群。


# 「力扣」分类以及题解目录（按照 LeetBook 的章节编排）

**说明**：题目分类与我的 LeetBook 章节对应，LeetBook 的课程标题、例题、练习都是公开的。

## 第 1 章 时间复杂度

这部分内容介绍了 时间复杂度 这个概念，可以收看 [视频讲解](https://leetcode-cn.com/leetbook/read/learning-algorithms-with-leetcode/xs3ij1/) ，完全免费。 这一章节没有练习。

## 第 2 章 二分查找

+ 可以我的  LeetBook 收看二分查找的知识点 [讲解](https://leetcode-cn.com/leetbook/read/learning-algorithms-with-leetcode/xsq0b7/)，免费；
+ 知识点讲解：[写对二分查找不能靠模板，需要理解加练习 （附练习题，持续更新）](https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/)、[视频讲解](https://www.bilibili.com/video/av83911694?p=1)。

### 题型一：二分求下标

+ 重点问题

| 题号 | 链接                                                         | 题解                                                         |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 704  | [二分查找](https://leetcode-cn.com/problems/binary-search/)（简单） |                                                              |
| 35   | [搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/)（简单） | [视频讲解](https://www.bilibili.com/video/av83911694?p=2)、[文字题解](https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/) |
| 34   | [在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)（简单） | [视频讲解](https://www.bilibili.com/video/av83911694?p=3)、[文字题解](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/si-lu-hen-jian-dan-xi-jie-fei-mo-gui-de-er-fen-cha/) |
| 1095 | [ 山脉数组中查找目标值](https://leetcode-cn.com/problems/find-in-mountain-array/)（中等） | [视频讲解](https://www.bilibili.com/video/BV1GK4115778)、[文字题解](https://leetcode-cn.com/problems/find-in-mountain-array/solution/shi-yong-chao-hao-yong-de-er-fen-fa-mo-ban-python-/) |
| 4    | [寻找两个有序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)（困难） | [视频讲解](https://www.bilibili.com/video/BV1Xv411z76J)、[文字题解](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/he-bing-yi-hou-zhao-gui-bing-guo-cheng-zhong-zhao-/) |


**说明**：

+ 第 34 题：二分查找找边界问题、[CSDN](https://blog.csdn.net/lw_power/article/details/104066739)、[庸才顾子汐：关于 while (left <= right) 写法返回值的详细讨论](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/da-jia-bu-yao-kan-labuladong-de-jie-fa-fei-chang-2/)；
+ 第 4 题：二分查找里最难的问题，重点在于理解：① 为什么是在短数组里找边界；② 边界条件的判断。

---

**练习**：


| 题号 | 链接                                                         | 题解                                                         |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 33   | [搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)（中等） | [文字题解](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/er-fen-fa-python-dai-ma-java-dai-ma-by-liweiwei141/) |
| 81   | [搜索旋转排序数组 II](https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/)（中等） | [文字题解](https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/er-fen-cha-zhao-by-liweiwei1419/) |
| 153  | [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)（中等） | [文字题解](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/er-fen-fa-fen-zhi-fa-python-dai-ma-java-dai-ma-by-/) |
| 154  | [154. 寻找旋转排序数组中的最小值 II](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/)（困难） | [文字题解](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/er-fen-fa-fen-zhi-fa-python-dai-ma-by-liweiwei1419/) |
| 275  | [ H指数 II](https://leetcode-cn.com/problems/h-index-ii/)（中等） | [文字题解](https://leetcode-cn.com/problems/h-index-ii/solution/jian-er-zhi-zhi-er-fen-cha-zhao-by-liweiwei1419-2/) |
| 436  | [寻找右区间](https://leetcode-cn.com/problems/find-right-interval/)（中等） | [文字题解](https://leetcode-cn.com/problems/find-right-interval/solution/er-fen-cha-zhao-hong-hei-shu-by-liweiwei1419/) |
| 1237 | [找出给定方程的正整数解](https://leetcode-cn.com/problems/find-positive-integer-solution-for-a-given-equation/)（中等） |                                                              |
| 1300 | [转变数组后最接近目标值的数组和](https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/)（中等） | [文字题解](https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/solution/er-fen-cha-zhao-by-liweiwei1419-2/) |




