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

### 题型二：二分确定一个有范围的整数（二分答案）

**算法思想**：减而治之。如果题目要我们找一个整数，这个整数有确定的范围，可以通过二分查找逐渐缩小范围，最后逼近到一个数。

| 题号 | 链接                                                         | 题解                                                         |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 69   | [x 的平方根](https://leetcode-cn.com/problems/sqrtx/)（简单） | [文字题解](https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/) |
| 287  | [寻找重复数](https://leetcode-cn.com/problems/find-the-duplicate-number/)（中等） | [文字题解](https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/) |
| 374  | [猜数字大小](https://leetcode-cn.com/problems/guess-number-higher-or-lower/)（简单） | [文字题解](https://leetcode-cn.com/problems/guess-number-higher-or-lower/solution/shi-fen-hao-yong-de-er-fen-cha-zhao-fa-mo-ban-pyth/) |
| 1283 | [使结果不超过阈值的最小除数](https://leetcode-cn.com/problems/find-the-smallest-divisor-given-a-threshold/)（中等） | [文字题解](https://leetcode-cn.com/problems/find-the-smallest-divisor-given-a-threshold/solution/er-fen-cha-zhao-ding-wei-chu-shu-by-liweiwei1419/) |
| 1292 | [元素和小于等于阈值的正方形的最大边长](https://leetcode-cn.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/)（中等） |                                                              |

### 题型三：复杂的判别函数（最大值极小化问题）

**说明**：这一类问题本质上还是「题型二」（二分答案），但是初学的时候会觉得有一些绕。这一类问题的问法都差不多，**关键字是「连续」、「正整数」**，请大家注意捕捉题目中这样的关键信息。

+ [二分查找之「最大值极小化」相关问题及解题步骤](https://juejin.im/post/6862249637161091085)
+ [二分查找之「最大值极小化」例题选讲](https://juejin.im/post/6864407058662457358/)

| 题号   | 链接                                                         | 题解                                                         |
| ------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 875    | [爱吃香蕉的珂珂](https://leetcode-cn.com/problems/koko-eating-bananas/)（中等） | [文字题解](https://leetcode-cn.com/problems/koko-eating-bananas/solution/er-fen-cha-zhao-ding-wei-su-du-by-liweiwei1419/) |
| 410    | [分割数组的最大值](https://leetcode-cn.com/problems/split-array-largest-sum/)（困难） | [文字题解](https://leetcode-cn.com/problems/split-array-largest-sum/solution/er-fen-cha-zhao-by-liweiwei1419-4/) |
| LCP 12 | [小张刷题计划](https://leetcode-cn.com/problems/xiao-zhang-shua-ti-ji-hua/)（中等） |                                                              |
| 1011   | [在 D 天内送达包裹的能力](https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days)（中等） |                                                              |
| 1482   | [制作 m 束花所需的最少天数](https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/)（中等） |                                                              |
| 1552   | [两球之间的磁力](https://leetcode-cn.com/problems/magnetic-force-between-two-balls/)（中等） |                                                              |

## 第 3 章 基础排序算法

这一部分包含了四种基础排序算法：选择排序、插入排序、希尔排序、冒泡排序。

「力扣」第 912 题：[排序数组](https://leetcode-cn.com/problems/sort-an-array/) 的 [题解](https://leetcode-cn.com/problems/sort-an-array/solution/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419/)：总结了排序问题的一些要点和学习资料，可以从排序问题开始学习算法。

数组的问题可以作为算法「新手场」，因为这些问题只需要掌握编程语言的基础知识就可以完成。以下问题都很容易想到解决方案，即使没有学习过相关的数据结构和算法知识。

#### 知识点：循环不变量

+ 循环不变量用于证明算法的有效性，也是编码正确的理论依据；
+ 循环不变量定义帮助分清先加还是先赋值，还有一些边界条件。定义清楚循环不变量以后，代码的编写就会很轻松；
+ 建议把「循环不变量」作为注释写在代码里，以方便自己调试和他人阅读。





| 题号 | 链接                                                         | 题解                                                         |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 912  | [排序数组](https://leetcode-cn.com/problems/sort-an-array)（中等） | [文字题解](https://leetcode-cn.com/problems/sort-an-array/solution/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419/) |
| 26   | [删除排序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array)（简单） |                                                              |
| 27   | [移除元素](https://leetcode-cn.com/problems/remove-element/)（简单） |                                                              |
| 283  | [移动零](https://leetcode-cn.com/problems/move-zeroes)（简单） | [文字题解](https://leetcode-cn.com/problems/move-zeroes/solution/zun-shou-xun-huan-bu-bian-shi-java-by-liweiwei1419/) |
|      |                                                              |                                                              |

## 第 4 章 高级排序算法（重要）

这一部分需要重点掌握三种高级排序算法：归并排序、快速排序、堆排序。

| 题号     | 链接                                                         | 题解                                                         |
| -------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 88       | [合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)（简单） | [从后向前归并](https://leetcode-cn.com/problems/merge-sorted-array/solution/si-xiang-mei-you-chuang-xin-de-di-fang-zhu-yao-ti-/) |
| 《剑》51 | [数组中的逆序对](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/)（困难） | [视频讲解](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/)、[文字题解](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/bao-li-jie-fa-fen-zhi-si-xiang-shu-zhuang-shu-zu-b/) |
| 75       | [颜色分类](https://leetcode-cn.com/problems/sort-colors/)（中等） | [文字题解](https://leetcode-cn.com/problems/sort-colors/solution/kuai-su-pai-xu-partition-guo-cheng-she-ji-xun-huan/) |
| 215      | [数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)（中等） | [文字题解](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/) |
| 451      | [根据字符出现频率排序](https://leetcode-cn.com/problems/sort-characters-by-frequency)（中等） |                                                              |

**说明**：

+ 第 88 题：归并排序，注意这里从后向前归并；
+ 《剑指 Offer》第 51 题：归并排序、树状数组（选学）；
+ 第 75 题：著名的「荷兰国旗」问题、快排；
+ 第 215 题：快排、优先队列；
+ 第 451 题：快排、优先队列。

## 第 5 章 非比较排序（选学）

这一部分包含了三种非比较排序排序：计数排序、基数排序、桶排序。解决这些问题需要知道 **原地哈希** 这个概念。

| 题号    | 链接                                                         | 题解                                                         |
| ------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 41      | [缺失的第一个正数](https://leetcode-cn.com/problems/first-missing-positive/)（困难） | [视频讲解](https://www.bilibili.com/video/BV167411N7vd)、[文字题解](https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/) |
| 《剑》3 | [剑指 Offer 03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/) |                                                              |
| 448     | [找到所有数组中消失的数字](https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/)（简单） |                                                              |
| 442     | [数组中重复的数据](https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/)（中等） |                                                              |




