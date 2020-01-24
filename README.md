# LeetCode-Solution-Well-Formed

## 项目更名说明

+ 更名为“Well-Formed”意为“格式良好”。我一直认为代码的可读性是非常重要的，代码可读的前提是“格式良好”，在 Intellij Idea、PyCharm、CLion 中，我使用最多的快捷键就是 `⌥ + ⌘ + L `（Reformate Code），希望看到这个项目的朋友们即使是刷题这种纯粹是“自娱自乐”的项目，也能够做到格式良好，方便他人和自己阅读。

**补充说明**：本人英语水平有限，想不到更好的名字，如果您有更好的想法，也欢迎告诉我，我一直都在为起名这件事情犯愁。

+ 添加了 Java 和 C++ 语言的代码。

## 项目说明

+ 本代码仓库是我在学习《算法与数据结构》的时候，在 [LeetCode（中文版）](https://leetcode-cn.com/) 上做的练习 。最开始的时候只有 Python 代码、然后陆续添加 Java 代码和 C++ 版本的代码。Java 是我的编程入门语言，Python 是学习人工智能以后学习的语言，C++ 就只是在刷题的时候用，因为有 Java 的基础，边写边学。

+ 所有的代码都是通过  [LeetCode（中文版）](https://leetcode-cn.com/) 在线测评系统检测的，至少是正确的代码，但本人水平有限，所在代码仅供参考，欢迎您与我交流。

+ 建议您安装 [Octotree 插件](https://www.octotree.io/?utm_source=lite&utm_medium=extension)，以获得最佳的阅读体验。

![Octotree 插件](https://liweiwei1419.github.io/images/leetcode-solution-new/Octotree.png)

## 编码依据

在代码编写的过程中，我比较注意的地方有：

1、格式良好

2、遵循代码规范

我遵守的代码规范和使用的工具如下：

| 编程语言 | 代码规范                                                     | 工具                                                         |
| -------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Java     | [阿里巴巴 Java 开发手册](https://github.com/alibaba/p3c)     | [Alibaba Java Coding Guidelines](https://plugins.jetbrains.com/plugin/10046-alibaba-java-coding-guidelines/) |
| Python   | [PEP 8 -- Style Guide for Python Code](https://www.python.org/dev/peps/pep-0008/) | [autopep8](https://github.com/hhatto/autopep8)、 [black](https://github.com/psf/black) |
| C++      | [Google Style Guides](https://github.com/google/styleguide)、[Google 开源项目风格指南 (中文版)](https://zh-google-styleguide.readthedocs.io/en/latest/) |                                                              |

个人建议：

（1）编码规范的遵守依照“就近原则”，如果程序员所处团队指定了编码规范，则团队内部代码规范优先；

（2）遵守格式良好和编码规范是一件很繁琐的事情，我们可以借助工具帮助我们完成，在 IDE 中安装上述插件，这些插件会对编码不规范的地方进行提示，并给出修改建议，能够帮助程序员养成良好的编码习惯。

3、使用集成开发环境

使用 jetbrains 公司开发的 IDE 工具。主要是为了使用代码格式化和扫描编码规范的插件

+ Java：Intellij Idea（Ultimate）
+ Python：PyCharm（Ultimate）
+ C++：CLion、Visual Studio Code（开源）

## 学习资源

我个人学习的资源如下，**仅供大家参考**。

1、书本

+ 《算法 4》：一本颜值很高的书，使用 Java 编写，示例清楚，配图优雅。很适合新手学习。缺点是：翻译欠缺，有些代码是封装过的，阅读起来让人摸不着头脑，给出的示例代码不规范。

+ 《算法导论》：当做工具书学习，其中的“动态规划”、“贪心算法”、“计数排序”、“基数排序”、“循环不变量”、“KMP”算法是讲解很细致的。缺点就是过于学术，不太适合算法和数据结构的入门教程。

2、网课与自媒体

+ 某课网 liuyubobobo 老师的算法与数据结构系列课程。我本人就是学习刘老师的课程入坑算法与数据结构的。（刘老师的课程是精心准备过，且是收费的，请大家自行判断是否需要购买。）
+ 可以在哔哩哩哔和 youtub 上搜索一些优秀的自媒体，听他们讲题也是很不错的学习途径，我常收看的自媒体有：花花酱，程序员刀刀，一俩三四五、lee215215、胡小旭-_-、喂你脚下有坑、代码会说话等。

3、优秀的博客、公众号

+ 在 2018 年，有一个制作算法动画的项目和公众号火了起来，让人耳目一新。公众号的名字叫“五分钟学算法”，博主叫“程序员吴师兄”，我在这个公众号上学习了很多东西，我现在的博客模板也是在吴师兄原来用的模板基础上做了修改。“程序员吴师兄”在很多平台上都可以搜索到他，欢迎大家关注。

4、加入一个学习团队，找到一两个小伙伴，刷题不会孤单

本人有幸加入了一个刷题 QQ 群（群号：812791932），如果刷题刷得比较烦躁，可以来群里和大家聊聊天，吹吹牛啥的。当然在群里提问，会有大佬、巨佬回答你的哟。

## 刷题建议

没有什么很特别的建议，但本人的确是通过以下的方式学习的。（仅供参考，本人只是个初学者。）

1、先学习，有一些预备知识以后，再做题

有些算法题做不出来很正常，那是因为自己的知识储备还不够。所以要么看书、看视频学习，要么就把这个不会做的问题当做知识点进行学习。一开始抄代码我觉得都是可以的，抄完代码要删掉了以后，自己再写几遍。

实在想了很久还想不出来的问题，就看题解和别人的视频学习哈。

2、要多做几遍，尝试做总结和分类

一道题，特别是经典的问题，要尝试多做几遍，作总结。有些问题的思想是通用的，而且技巧也是相对固定的，需要不断练习巩固和体会。

3、尝试一题多解，不要忽视暴力解法

一题多解，有些时候就相当于做了几遍了。“暴力解法”通常是进阶解法的基础，由“暴力解法”开始分析缺点，然后改进和优化，去理解这道题的解法通常是很自然的。

4、尝试输出，分享出去

较多程序员（包括我本人）相对欠缺的能力是语言表达和书面表达。而输出就是一个比较好的锻炼自己的方式，写博客写题解可以帮助到别人，也可以帮助自己整理思路，还可以交朋友。

我写题解以后，有很多朋友给出提出了建议，指出了错误，让我受益匪浅。有一些朋友加了我微信和 QQ，我很高兴与它们交流，成为朋友。

5、参加竞赛，练手

前面的题目可能就像课后练习一样，你做不做它就在那里，就有那么多，还可以看答案，做起来没什么动力。想模拟面试和笔试的感觉，就可以参加竞赛哦。

我最近两个月开始参加「力扣」的周赛和双周赛。刚开始的时候，因为有一些事情脱不开身，就只是打了个卡，一道题都没做。现在基本上 2 道题到 3 道题还是可以做出来的。难题赛后会进行学习，做一个笔记。

参加竞赛是一个很不错的学习途径，培养自己独立思考的能力，还可以与他人互动。

> 希望我们程序员都能够通过自己的努力，实现自己的理想。
>
> 希望我们程序员不再是别人眼里的刻板印象，我们也是艺术家。
>
> 希望我们大家都能在自己的工作领域里有所成绩。很高兴和大家成为朋友。

## 题解分类（正在更新）

### 栈

| 题目序号                                                     | 题解                                                         | 知识点   | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | -------- | ---- |
| [316. 去除重复字母](https://leetcode-cn.com/problems/remove-duplicate-letters/) | [栈 + 哨兵技巧（Java、C++、Python）](https://leetcode-cn.com/problems/remove-duplicate-letters/solution/zhan-by-liweiwei1419/) | 穿针引线 |      |
| [225. 用队列实现栈](https://leetcode-cn.com/problems/implement-stack-using-queues/) | [负负得正，peek 和 pop 时，依次将队首元素出队，放到队尾](https://leetcode-cn.com/problems/implement-stack-using-queues/solution/peek-he-pop-shi-yi-ci-jiang-dui-shou-yuan-su-chu-d/) |          |      |

### 链表

| 题目序号                                                     | 题解                                                         | 知识点   |
| ------------------------------------------------------------ | ------------------------------------------------------------ | -------- |
| [61. 旋转链表](https://leetcode-cn.com/problems/rotate-list/) | [穿针引线](https://leetcode-cn.com/problems/rotate-list/solution/chuan-zhen-yin-xian-by-liweiwei1419/) | 穿针引线 |

### 二分查找

知识点讲解：[用“排除法”（减治思想）写二分查找问题、与其它二分查找模板的比较](https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/)、[哔哩哔哩](https://www.bilibili.com/video/av83911694?p=1)

| 题目序号                                                     | 题解                                                         | 知识点                                                       | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ---- |
| [704. 二分查找](https://leetcode-cn.com/problems/binary-search/) |                                                              |                                                              |      |
| [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | [「力扣」题解](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/si-lu-hen-jian-dan-xi-jie-fei-mo-gui-de-er-fen-cha/)、[CSDN](https://blog.csdn.net/lw_power/article/details/104066739)、[哔哩哔哩](https://www.bilibili.com/video/av83911694?p=3) | 二分查找找边界。                                             |      |
| [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/) | [二分法](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/er-fen-fa-python-dai-ma-java-dai-ma-by-liweiwei141/) |                                                              |      |
| [81. 搜索旋转排序数组 II](https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/) | [二分查找](https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/er-fen-cha-zhao-by-liweiwei1419/) |                                                              |      |
| [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/) | [二分查找 + 分治法](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/er-fen-fa-fen-zhi-fa-python-dai-ma-java-dai-ma-by-/) |                                                              |      |
| [154. 寻找旋转排序数组中的最小值 II](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/) | [二分查找 + 分治法](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/er-fen-fa-fen-zhi-fa-python-dai-ma-by-liweiwei1419/) |                                                              |      |
| [35. 搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/) | [十分好用的二分查找法模板](https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/)、[哔哩哔哩](https://www.bilibili.com/video/av83911694?p=2) |                                                              |      |
| [69. x 的平方根](https://leetcode-cn.com/problems/sqrtx/)    | [二分查找 + 牛顿法（Python 代码、Java 代码）](https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/) |                                                              |      |
| [275. H指数 II](https://leetcode-cn.com/problems/h-index-ii/) | [减而治之、二分查找](https://leetcode-cn.com/problems/h-index-ii/solution/jian-er-zhi-zhi-er-fen-cha-zhao-by-liweiwei1419-2/) |                                                              |      |
| [300. 最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/) | [动态规划 、贪心算法 + 二分](https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/) |                                                              |      |
| [354. 俄罗斯套娃信封问题](https://leetcode-cn.com/problems/russian-doll-envelopes/) | [贪心算法、二分查找（Python 代码、Java 代码）](https://leetcode-cn.com/problems/russian-doll-envelopes/solution/tan-xin-suan-fa-er-fen-cha-zhao-python-dai-ma-java/) |                                                              |      |
| [374. 猜数字大小](https://leetcode-cn.com/problems/guess-number-higher-or-lower/) | [借本题说一说取中位数的写法（Python 代码、Java 代码）](https://leetcode-cn.com/problems/guess-number-higher-or-lower/solution/shi-fen-hao-yong-de-er-fen-cha-zhao-fa-mo-ban-pyth/) |                                                              |      |
| [436. 寻找右区间](https://leetcode-cn.com/problems/find-right-interval/) | [二分查找、二分搜索树](https://leetcode-cn.com/problems/find-right-interval/solution/er-fen-cha-zhao-hong-hei-shu-by-liweiwei1419/) |                                                              |      |
| [410. 分割数组的最大值](https://leetcode-cn.com/problems/split-array-largest-sum/) |                                                              |                                                              |      |
| [875. 爱吃香蕉的珂珂](https://leetcode-cn.com/problems/koko-eating-bananas/) | [二分查找定位速度（C++、Java、Python）](https://leetcode-cn.com/problems/koko-eating-bananas/solution/er-fen-cha-zhao-ding-wei-su-du-by-liweiwei1419/) |                                                              |      |
| [1095. 山脉数组中查找目标值](https://leetcode-cn.com/problems/find-in-mountain-array/) | [十分好用的二分查找法模板（Python 代码、Java 代码）](https://leetcode-cn.com/problems/find-in-mountain-array/solution/shi-yong-chao-hao-yong-de-er-fen-fa-mo-ban-python-/) |                                                              |      |
| [1237. 找出给定方程的正整数解](https://leetcode-cn.com/problems/find-positive-integer-solution-for-a-given-equation/) |                                                              |                                                              |      |
| [1283. 使结果不超过阈值的最小除数](https://leetcode-cn.com/problems/find-the-smallest-divisor-given-a-threshold/) | [二分查找定位除数](https://leetcode-cn.com/problems/find-the-smallest-divisor-given-a-threshold/solution/er-fen-cha-zhao-ding-wei-chu-shu-by-liweiwei1419/) |                                                              |      |
| [1292. 元素和小于等于阈值的正方形的最大边长](https://leetcode-cn.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/) |                                                              |                                                              |      |
| [1300. 转变数组后最接近目标值的数组和](https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/) | [二分查找](https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/solution/er-fen-cha-zhao-by-liweiwei1419-2/) |                                                              |      |
| [287. 寻找重复数](https://leetcode-cn.com/problems/find-the-duplicate-number/) | [使用二分法在候选区间里定位目标数值（C++、Java、Python）](https://leetcode-cn.com/problems/find-the-duplicate-number/solution/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/) | 使用二分法定位一个有范围的整数。                             |      |
| [4. 寻找两个有序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/) | [二分查找定位短数组的“边界线”](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/he-bing-yi-hou-zhao-gui-bing-guo-cheng-zhong-zhao-/) | 二分查找里最难的问题，主要弄清楚：1、为什么是在短数组里找边界；2、边界条件的判断。 |      |

### 回溯算法

知识点讲解：

| 题目序号                                                     | 题解 | 知识点 | 代码 |
| ------------------------------------------------------------ | ---- | ------ | ---- |
| [47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/) |      |        |      |
| [17 .电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/) |      |        |      |
| [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/) |      |        |      |
| [39. 组合总和](https://leetcode-cn.com/problems/combination-sum/) |      |        |      |
| [40. 组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii/) |      |        |      |
| [51. N皇后](https://leetcode-cn.com/problems/n-queens/)      |      |        |      |
| [60. 第k个排列](https://leetcode-cn.com/problems/permutation-sequence/) |      |        |      |
| [77. 组合](https://leetcode-cn.com/problems/combinations/)   |      |        |      |
| [78. 子集](https://leetcode-cn.com/problems/subsets/)        |      |        |      |
| [90. 子集 II](https://leetcode-cn.com/problems/subsets-ii/)  |      |        |      |
| [93. 复原IP地址](https://leetcode-cn.com/problems/restore-ip-addresses/) |      |        |      |
| [784. 字母大小写全排列](https://leetcode-cn.com/problems/letter-case-permutation/) |      |        |      |

### 动态规划

知识点讲解：在「力扣」第 5 题[题解](https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/)。

| 题目序号                                                     | 题解                                                         | 知识点                                                    | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | --------------------------------------------------------- | ---- |
| [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/) | [CSDN](https://blog.csdn.net/lw_power/article/details/103799112) |                                                           |      |
| [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/) | [Manacher 算法 + 动态规划 （Java、C++、Python）](https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/) | 使用动态规划的方法得到子串的回文性质                      |      |
| [416. 分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/) | [动态规划（0-1 背包问题）](https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/) | 很重要的动态规划模型，必须掌握                            |      |
| [121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/) | [暴力枚举 + 动态规划 + 差分思想](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/)、[CSDN](https://blog.csdn.net/lw_power/article/details/103772951) |                                                           |      |
| [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/) | [暴力搜索 + 贪心算法 + 动态规划](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/)、[CSDN](https://blog.csdn.net/lw_power/article/details/103773246) |                                                           |      |
| [123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/) | [CSDN](https://blog.csdn.net/lw_power/article/details/103773822) | 1、从后向前写可以把状态压缩到一维；2、分解成两个 121 题。 |      |
| [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/) | [CDSN](https://blog.csdn.net/lw_power/article/details/103818533) |                                                           |      |
| [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray) | [动态规划、分治法](https://leetcode-cn.com/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/)、[CSDN](https://blog.csdn.net/lw_power/article/details/104062895) | 1、经典动态规划问题；2、分治                              |      |
| [300. 最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/) | [动态规划 、贪心算法 + 二分](https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/) |                                                           |      |

### 优先队列

| 题目序号                                                     | 题解                                                         | 知识点       | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------ | ---- |
| [215. 数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/) | [通过 partition 减治 + 优先队列（Java、C++、Python）](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/) | 减而治之、堆 |      |

## 配套资源

+ 发布在 LeetCode 中文版上的题解配图使用的 PPT，传送门：[https://github.com/liweiwei1419/LeetCode-Solution-PPT](https://github.com/liweiwei1419/LeetCode-Solution-PPT)

说明：做了 PPT 或者动画的题目，一般在 LeetCode 中文版的题解区都能看到我写的题解。

## 刷题过程中形成的文章（待更新）

| 第 1 章 数组                                                 | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/03-%E6%95%B0%E7%BB%84%E9%97%AE%E9%A2%98) |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| LeetCode 数组专题 1：二分查找                                | [链接地址](https://liweiwei1419.github.io/blog/2018/10/14/leetcode-solution/array1/) |
| LeetCode 数组专题 2：一些关于数组的问题                      | [链接地址](https://liweiwei1419.github.io/blog/2018/10/15/leetcode-solution/array2/) |
| LeetCode 数组专题 3：三路快排 partition 的应用               | [链接地址](https://liweiwei1419.github.io/blog/2018/10/16/leetcode-solution/array3/) |
| LeetCode 数组专题 4：双索引技术之一：对撞指针                | [链接地址](https://liweiwei1419.github.io/blog/2018/10/17/leetcode-solution/two-pointers/) |
| LeetCode 数组专题 5：双索引技术之二：滑动窗口                | [链接地址](https://liweiwei1419.github.io/blog/2018/10/18/leetcode-solution/array5/) |
| LeetCode 数组专题 6：其它数组问题                            | [链接地址](https://liweiwei1419.github.io/blog/2018/10/19/leetcode-solution/array6/) |
| **第 2 章 查找表**                                           | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/04-%E6%9F%A5%E6%89%BE%E8%A1%A8%E9%97%AE%E9%A2%98) |
| LeetCode 查找表专题 1：查找问题简介                          | [链接地址](https://liweiwei1419.github.io/blog/2018/10/06/leetcode-solution/hash-table-1/) |
| LeetCode 查找表专题 2：哈希表的使用                          | [链接地址](https://liweiwei1419.github.io/blog/2018/10/07/leetcode-solution/hash-table-2/) |
| LeetCode 查找表专题 3：set 和 map 不同底层实现的区别         | [链接地址](https://liweiwei1419.github.io/blog/2018/10/08/leetcode-solution/hash-table-3/) |
| LeetCode 查找表专题 4：使用查找表的经典问题：Two Sum         | [链接地址](https://liweiwei1419.github.io/blog/2018/10/09/leetcode-solution/hash-table-4/) |
| LeetCode 查找表专题 5：灵活选择键值：4Sum II                 | [链接地址](https://liweiwei1419.github.io/blog/2018/10/10/leetcode-solution/hash-table-5/) |
| LeetCode 查找表专题 6：灵活选择键值：Number of Boomerangs    | [链接地址](https://liweiwei1419.github.io/blog/2018/10/11/leetcode-solution/hash-table-6/) |
| LeetCode 查找表专题 7：查找表和滑动窗口                      | [链接地址](https://liweiwei1419.github.io/blog/2018/10/12/leetcode-solution/hash-table-7/) |
| LeetCode 查找表专题 8：使用树结构                            | [链接地址](https://liweiwei1419.github.io/blog/2018/10/13/leetcode-solution/hash-table-8/) |
| **第 3 章 单链表**                                           | [代码文件夹]()                                               |
| LeetCode 链表专题 1：在链表中穿针引线                        | [链接地址](https://liweiwei1419.github.io/blog/2018/09/01/leetcode-solution/linked-list-1/) |
| LeetCode 链表专题 2：测试你的链表程序                        | [链接地址](https://liweiwei1419.github.io/blog/2018/09/02/leetcode-solution/linked-list-2/) |
| LeetCode 链表专题 3：设立链表的虚拟头结点                    | [链接地址](https://liweiwei1419.github.io/blog/2018/09/03/leetcode-solution/linked-list-3/) |
| LeetCode 链表专题 4：复杂的穿针引线                          | [链接地址](https://liweiwei1419.github.io/blog/2018/09/04/leetcode-solution/linked-list-4/) |
| LeetCode 链表专题 5：不仅仅是穿针引线                        | [链接地址](https://liweiwei1419.github.io/blog/2018/09/05/leetcode-solution/linked-list-5/) |
| LeetCode 链表专题 6：链表与双指针                            | [链接地址](https://liweiwei1419.github.io/blog/2018/09/06/leetcode-solution/linked-list-6/) |
| **第 4 章 栈、队列、优先队列**                               | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/06-%E6%A0%88%E3%80%81%E9%98%9F%E5%88%97%E3%80%81%E4%BC%98%E5%85%88%E9%98%9F%E5%88%97) |
| LeetCode 栈、队列、优先队列专题 1：栈和队列的使用            | [链接地址](https://liweiwei1419.github.io/blog/2018/09/30/leetcode-solution/stack-1/) |
| LeetCode 栈、队列、优先队列专题 2：二叉树的三种非递归实现    | [链接地址](https://liweiwei1419.github.io/blog/2018/10/01/leetcode-solution/stack-2/) |
| LeetCode 栈、队列、优先队列专题 3：使用自己编写的模拟系统栈，写出非递归的程序 | [链接地址](https://liweiwei1419.github.io/blog/2018/10/02/leetcode-solution/stack-3/) |
| LeetCode 栈、队列、优先队列专题 4：队列 Queue 与广度优先遍历 | [链接地址](https://liweiwei1419.github.io/blog/2018/10/03/leetcode-solution/queue-1/) |
| LeetCode 栈、队列、优先队列专题 5：广度优先遍历和图的最短路径问题 | [链接地址](https://liweiwei1419.github.io/blog/2018/10/04/leetcode-solution/queue-2/) |
| LeetCode 栈、队列、优先队列专题 6：优先队列也是队列          | [链接地址](https://liweiwei1419.github.io/blog/2018/10/05/leetcode-solution/priority-queue/) |
| **第 5 章 二叉树和递归**                                     | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/07-%E4%BA%8C%E5%8F%89%E6%A0%91%E5%92%8C%E9%80%92%E5%BD%92) |
| LeetCode 二叉树和递归专题 1：从二叉树的角度看递归            | [链接地址](https://liweiwei1419.github.io/blog/2018/09/24/leetcode-solution/binary-tree-1/) |
| LeetCode 二叉树和递归专题 2：一个简单的二叉树引发的血案      | [链接地址](https://liweiwei1419.github.io/blog/2018/09/25/leetcode-solution/binary-tree-2/) |
| LeetCode 二叉树和递归专题 3：注意递归的终止条件              | [链接地址](https://liweiwei1419.github.io/blog/2018/09/26/leetcode-solution/binary-tree-3/) |
| LeetCode 二叉树和递归专题 4：如何使用递归函数的返回值        | [链接地址](https://liweiwei1419.github.io/blog/2018/09/27/leetcode-solution/binary-tree-4/) |
| LeetCode 二叉树和递归专题 5：稍复杂的递归逻辑 Path Sum III   | [链接地址](https://liweiwei1419.github.io/blog/2018/09/28/leetcode-solution/binary-tree-5/) |
| LeetCode 二叉树和递归专题 6：二分搜索树中的问题              | [链接地址](https://liweiwei1419.github.io/blog/2018/09/29/leetcode-solution/binary-tree-6/) |
| **第 6 章 回溯问题**                                         | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/08-%E9%80%92%E5%BD%92%E5%92%8C%E5%9B%9E%E6%BA%AF%E6%B3%95) |
| LeetCode 回溯专题 1：在树形问题中使用递归                    | [链接地址](https://liweiwei1419.github.io/blog/2018/09/07/leetcode-solution/backtracking-1/) |
| LeetCode 回溯专题 2：回溯法是暴力解法的一个主要的实现手段    | [链接地址](https://liweiwei1419.github.io/blog/2018/09/08/leetcode-solution/backtracking-2/) |
| LeetCode 回溯专题 3：排列问题 Permutations                   | [链接地址](https://liweiwei1419.github.io/blog/2018/09/09/leetcode-solution/backtracking-3/) |
| LeetCode 回溯专题 4：组合问题 Combinations                   | [链接地址](https://liweiwei1419.github.io/blog/2018/09/10/leetcode-solution/backtracking-4/) |
| LeetCode 回溯专题 5：回溯法解决组合问题的优化                | [链接地址](https://liweiwei1419.github.io/blog/2018/09/11/leetcode-solution/backtracking-5/) |
| LeetCode 回溯专题 6：二维平面上使用回溯法                    | [链接地址](https://liweiwei1419.github.io/blog/2018/09/12/leetcode-solution/backtracking-6/) |
| LeetCode 回溯专题 7：floodfill 解决一类经典问题              | [链接地址](https://liweiwei1419.github.io/blog/2018/09/13/leetcode-solution/backtracking-7/) |
| LeetCode 回溯专题 8：回溯法是经典的人工智能的基础            | [链接地址](https://liweiwei1419.github.io/blog/2018/09/14/leetcode-solution/backtracking-8/) |
| **第 7 章 动态规划问题**                                     | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/09-%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92) |
| LeetCode 动态规划专题 1：“重叠子问题”和“记忆化搜索”          | [链接地址](https://liweiwei1419.github.io/blog/2018/09/15/leetcode-solution/dynamic-programming-1/) |
| LeetCode 动态规划专题 2：第 1 个动态规划问题的 3 种实现      | [链接地址](https://liweiwei1419.github.io/blog/2018/09/16/leetcode-solution/dynamic-programming-2/) |
| LeetCode 动态规划专题 3：第 2 个动态规划问题：整数分割       | [链接地址](https://liweiwei1419.github.io/blog/2018/09/16/leetcode-solution/dynamic-programming-3/) |
| LeetCode 动态规划专题 4：状态和状态转移方程                  | [链接地址](https://liweiwei1419.github.io/blog/2018/09/16/leetcode-solution/dynamic-programming-4/) |
| LeetCode 动态规划专题 5：0-1 背包问题                        | [链接地址](https://liweiwei1419.github.io/blog/2018/09/16/leetcode-solution/dynamic-programming-5/) |
| LeetCode 动态规划专题 6：0-1 背包问题在空间复杂度上的两个优化 | [链接地址](https://liweiwei1419.github.io/blog/2018/09/16/leetcode-solution/dynamic-programming-6/) |
| LeetCode 动态规划专题 7：面试中的 0-1 背包问题               | [链接地址](https://liweiwei1419.github.io/blog/2018/09/16/leetcode-solution/dynamic-programming-7/) |
| LeetCode 动态规划专题 8：最长上升子序列问题                  | [链接地址](https://liweiwei1419.github.io/blog/2018/09/16/leetcode-solution/dynamic-programming-8/) |
| **第 8 章 贪心算法**                                         | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/10-%E8%B4%AA%E5%BF%83%E7%AE%97%E6%B3%95) |
| LeetCode 专题：贪心算法                                      | [链接地址](https://liweiwei1419.github.io/blog/2018/09/04/leetcode-tag/greedy/) |
| **第 9 章 拓扑排序**                                         | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/11-%E6%8B%93%E6%89%91%E6%8E%92%E5%BA%8F) |
| LeetCode 专题：拓扑排序                                      | [链接地址](https://liweiwei1419.github.io/blog/2019/02/16/leetcode-tag/topological-sort/) |
| **第 10 章 字典树**                                          | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/12-trie) |
| 【算法日积月累】20-高级数据结构：字典树                      | [链接地址](https://liweiwei1419.github.io/blog/2019/01/21/algorithms-and-data-structures/trie/) |
| **第 11 章 并查集**                                          | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/13-%E5%B9%B6%E6%9F%A5%E9%9B%86) |
| 【算法日积月累】17-高级数据结构：并查集                      | [链接地址](https://liweiwei1419.github.io/blog/2019/01/18/algorithms-and-data-structures/union-find-set/) |
| **第 12 章 位运算**                                          | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/14-%E4%BD%8D%E8%BF%90%E7%AE%97) |
| LeetCode 专题：位运算                                        | [链接地址](https://liweiwei1419.github.io/blog/2018/09/25/leetcode-tag/bit-manipulation/) |
| **第 13 章 树状数组**                                        | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/15-%E6%A0%91%E7%8A%B6%E6%95%B0%E7%BB%84) |
| 【算法日积月累】19-高级数据结构：树状数组                    | [链接地址](https://liweiwei1419.github.io/blog/2019/01/20/algorithms-and-data-structures/fenwick-tree/) |
| **第 14 章 分治算法**                                        | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/16-%E5%88%86%E6%B2%BB) |
| [整理中]                                                     |                                                              |
| **第 15 章 二分查找**                                        | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/17-%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE) |
| LeetCode 专题：二分查找                                      | [链接地址](https://liweiwei1419.github.io/blog/2019/01/13/algorithms-and-data-structures/binary-search/) |
| **第 16 章 线段树**                                          | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/18-%E7%BA%BF%E6%AE%B5%E6%A0%91) |
| 【算法日积月累】18-高级数据结构：线段树                      | [链接地址](https://liweiwei1419.github.io/blog/2019/01/19/algorithms-and-data-structures/segment-tree/) |
| **第 17 章 数学问题**                                        | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/19-%E6%95%B0%E5%AD%A6) |
| [整理中]                                                     |                                                              |
| **第 18 章 优先队列**                                        | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/20-%E4%BC%98%E5%85%88%E9%98%9F%E5%88%97) |
| [整理中]                                                     |                                                              |
| **第 19 章 字符串**                                          | [代码文件夹](https://github.com/liweiwei1419/LeetCode-Solution-Python/tree/master/21-%E5%AD%97%E7%AC%A6%E4%B8%B2) |
| [整理中]                                                     |                                                              |

