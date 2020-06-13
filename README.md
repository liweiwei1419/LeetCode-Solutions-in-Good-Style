# LeetCode-Solution-in-Good-Style

## 项目更名说明

+ 在这里，特别感谢 [@AbbyDeng](https://github.com/AbbyDeng) 同学的更名建议；
+ 我个人觉得代码的可读性是非常重要的，代码可读的前提是「格式良好」，在 Intellij Idea、PyCharm、CLion 中，我使用最多的快捷键就是 `⌥ + ⌘ + L `（Reformate Code），希望看到这个项目的朋友们，即使是刷题这种纯粹是「自娱自乐」的项目，也能够做到格式良好，方便他人和自己阅读。

## 项目说明

+ 本代码仓库是我在学习《算法与数据结构》的时候，在 [LeetCode（力扣）](https://leetcode-cn.com/) 上做的练习 ；刷题以 Java 语言为主，Java 是我的编程入门语言，Python 是学习人工智能以后学习的语言，C++ 就只是在刷题的时候用，因为有 Java 的基础，边写边学；

+ 所有的代码都是通过  [LeetCode（力扣）](https://leetcode-cn.com/) 在线测评系统检测的，至少是正确的代码，但本人水平有限，所在代码仅供参考，欢迎您与我交流；

+ 建议您安装 [Octotree 插件](https://www.octotree.io/?utm_source=lite&utm_medium=extension)，以获得最佳的阅读体验。

![Octotree 插件](http://liweiwei1419.gitee.io/visualgo/github/octotree.png)

## 编码依据

在代码编写的过程中，我比较注意的地方有：

+ 格式良好；
+ 遵循代码规范。

我遵守的代码规范和使用的工具如下：

| 编程语言 | 代码规范                                                     | 工具                                                         |
| -------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Java     | [阿里巴巴 Java 开发手册](https://github.com/alibaba/p3c)     | [Alibaba Java Coding Guidelines](https://plugins.jetbrains.com/plugin/10046-alibaba-java-coding-guidelines/) |
| Python   | [PEP 8 -- Style Guide for Python Code](https://www.python.org/dev/peps/pep-0008/) | [autopep8](https://github.com/hhatto/autopep8)、 [black](https://github.com/psf/black) |
| C++      | [Google Style Guides](https://github.com/google/styleguide)、[Google 开源项目风格指南 (中文版)](https://zh-google-styleguide.readthedocs.io/en/latest/) |                                                              |

### 个人建议

+ 编码规范的遵守依照「就近原则」，如果程序员所处团队指定了编码规范，则团队内部代码规范优先；
+ 遵守格式良好和编码规范是一件很繁琐的事情，我们可以借助工具帮助我们完成，在 IDE 中安装上述插件，这些插件会对编码不规范的地方进行提示，并给出修改建议，能够帮助程序员养成良好的编码习惯。

### 使用的集成开发环境

使用 Jetbrains 公司开发的 IDE 工具。主要是为了使用代码格式化和扫描编码规范的插件：

+ Java：Intellij Idea（Ultimate）
+ Python：PyCharm（Ultimate）
+ C++：CLion、Visual Studio Code（开源）

## 学习资源

我个人学习的资源如下，**仅供大家参考**。

### 1、书本

+ 《算法 4》：一本颜值很高的书，使用 Java 编写，示例清楚，配图优雅。很适合新手学习。缺点是：翻译欠缺，给出的示例代码不规范，阅读起来让人觉得很困惑；

+ 《算法导论》：当做工具书学习，其中的「动态规划」、「贪心算法」、「计数排序」、「基数排序」、「循环不变量」、「KMP」算法是讲解很细致的。缺点就是过于学术，不太适合算法和数据结构的入门教程。

### 2、网课与自媒体

+ 慕课网 liuyubobobo 老师的算法与数据结构系列课程。我本人就是学习刘老师的课程入坑算法与数据结构的。（刘老师的课程是精心准备过，且是收费的，请大家自行判断是否需要购买。）
+ 可以在哔哩哩哔和 youtub 上搜索一些优秀的自媒体，听他们讲题也是很不错的学习途径，我常收看的自媒体有：花花酱，程序员刀刀，一俩三四五、lee215215、胡小旭-_-、喂你脚下有坑、代码会说话等。

### 3、优秀的博客、公众号

+ 在 2018 年，有一个制作算法动画的项目和公众号火了起来，让人耳目一新。公众号的名字叫「五分钟学算法」，博主叫「程序员吴师兄」，我在这个公众号上学习了很多东西，我现在的博客模板也是在吴师兄原来用的模板基础上做了修改。“程序员吴师兄”在很多平台上都可以搜索到他，欢迎大家关注。

### 4、加入一个学习团队，找到一两个小伙伴，刷题不会孤单

+ 本人有幸加入了一个刷题 QQ 群（群号：812791932），如果刷题刷得比较烦躁，可以来群里和大家聊聊天，吹吹牛啥的。在群里提问，会有大佬、巨佬、巨巨佬回答你的哟；
+ 最近「力扣」网站举办了「每日一题」，习惯用微信的朋友可以点击网址：https://ojeveryday.com/#/check，加群主微信，这个网页还会显示大家打卡的情况。

## 刷题建议

没有什么很特别的建议，但本人的确是通过以下的方式学习的。（仅供参考，本人只是个初学者。）

+ 先学习，有一些预备知识以后，再做题

有些算法题做不出来很正常，那是因为自己的知识储备还不够。所以要么看书、看视频学习，要么就把这个不会做的问题当做知识点进行学习。一开始抄代码我觉得都是可以的，抄完代码要删掉了以后，自己再写几遍。

实在想了很久还想不出来的问题，就看题解和别人的视频学习哈。

+ 要多做几遍，尝试做总结和分类

一道题，特别是经典的问题，要尝试多做几遍，作总结。有些问题的思想是通用的，而且技巧也是相对固定的，需要不断练习巩固和体会。

+ 尝试一题多解，不要忽视暴力解法

一题多解，有些时候就相当于做了几遍了。“暴力解法”通常是进阶解法的基础，由“暴力解法”开始分析缺点，然后改进和优化，去理解这道题的解法通常是很自然的。

+ 尝试输出，分享出去

较多程序员（包括我本人）相对欠缺的能力是语言表达和书面表达。而输出就是一个比较好的锻炼自己的方式，写博客写题解可以帮助到别人，也可以帮助自己整理思路，还可以交朋友。

我写题解以后，有很多朋友给出提出了建议，指出了错误，让我受益匪浅。有一些朋友加了我微信和 QQ，我很高兴与它们交流，成为朋友。

+ 参加竞赛，练手

前面的题目可能就像课后练习一样，你做不做它就在那里，就有那么多，还可以看答案，做起来没什么动力。想模拟面试和笔试的感觉，就可以参加竞赛哦。

我最近两个月开始参加「力扣」的周赛和双周赛。刚开始的时候，因为有一些事情脱不开身，就只是打了个卡，一道题都没做。现在基本上 2 道题到 3 道题还是可以做出来的。难题赛后会进行学习，做一个笔记。

参加竞赛是一个很不错的学习途径，培养自己独立思考的能力，还可以与他人互动。

如果是已经工作的朋友，竞赛的第 4 题可以不做，竞赛是一个查缺补漏的过程，有些知识可能目前或者是一辈子都用不到的知识，可以不用掌握。

> 希望我们程序员都能够通过自己的努力，实现自己的理想；
>
> 希望我们程序员不再是别人眼里的刻板印象，我们也是艺术家；
>
> 希望我们大家都能在自己的工作领域里有所成绩。很高兴和大家成为朋友。

## 「力扣」2020 年 4 月每日一题做题记录

| 日期         | 题目                                                         | 难度 | 题解                                                         |
| ------------ | ------------------------------------------------------------ | ---- | ------------------------------------------------------------ |
| 4 月 1 日    | [1111. 有效括号的嵌套深度](https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/) | 中等 | [嵌套深度 = 完成括号匹配问题实际使用的栈的最大高度](https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/solution/qian-tao-shen-du-wan-cheng-gua-hao-pi-pei-wen-ti-s/) |
| 4 月 2 日    | [289. 生命游戏](https://leetcode-cn.com/problems/game-of-life/) | 中等 | [「力扣」第 289 题：生命游戏（数组）](https://blog.csdn.net/lw_power/article/details/105264037) |
| 4 月 3 日    | [8. 字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/) | 中等 | [尽量不使用库函数、一次遍历（Java）](https://leetcode-cn.com/problems/string-to-integer-atoi/solution/jin-liang-bu-shi-yong-ku-han-shu-nai-xin-diao-shi-/) |
| 4 月 4 日    | [42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/) | 困难 | [暴力解法、优化、双指针、单调栈](https://leetcode-cn.com/problems/trapping-rain-water/solution/bao-li-jie-fa-yi-kong-jian-huan-shi-jian-zhi-zhen-/) |
| 4 月 5 日    | [460. LFU缓存](https://leetcode-cn.com/problems/lfu-cache/)  | 困难 | [哈希表 + 双向链表（Java）](https://leetcode-cn.com/problems/lfu-cache/solution/ha-xi-biao-shuang-xiang-lian-biao-java-by-liweiwei/) |
| （同类问题） | [146. LRU缓存机制](https://leetcode-cn.com/problems/lru-cache/) | 中等 | [哈希表 + 双向链表（Java）](https://leetcode-cn.com/problems/lru-cache/solution/ha-xi-biao-shuang-xiang-lian-biao-java-by-liweiw-2/) |
| 4 月 6 日    | [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/) | 困难 | [动态规划（Java）](https://leetcode-cn.com/problems/edit-distance/solution/dong-tai-gui-hua-java-by-liweiwei1419/) |
| 4 月 7 日    | [面试题 01.07. 旋转矩阵](https://leetcode-cn.com/problems/rotate-matrix-lcci/) | 中等 | [CSDN](https://blog.csdn.net/lw_power/article/details/105317509) |
| 4 月 8 日    | [机器人的运动范围](https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof) | 中等 | [深度优先遍历、广度优先遍历](https://blog.csdn.net/lw_power/article/details/105398995) |
| 4 月 9 日    | [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/) | 中等 | [回溯算法（深度优先遍历）+ 广度优先遍历 + 动态规划](https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/) |
| 4 月 10 日   | [151. 翻转字符串里的单词](https://leetcode-cn.com/problems/reverse-words-in-a-string/) | 中等 | [CSDN](https://blog.csdn.net/lw_power/article/details/105317713) |
| 4 月 11 日   | [887. 鸡蛋掉落](https://leetcode-cn.com/problems/super-egg-drop/) | 困难 | [动态规划（只解释官方题解方法一）（Java）](https://leetcode-cn.com/problems/super-egg-drop/solution/dong-tai-gui-hua-zhi-jie-shi-guan-fang-ti-jie-fang/) |
| 4 月 12 日   | [面试题 16.03. 交点](https://leetcode-cn.com/problems/intersection-lcci/) | 困难 | [使用直线斜截式方程，再判断交点是否有效（Java）](https://leetcode-cn.com/problems/intersection-lcci/solution/shi-yong-zhi-xian-xie-jie-shi-fang-cheng-zai-pan-d/) |
| 4 月 13 日   | [355. 设计推特](https://leetcode-cn.com/problems/design-twitter/) | 中等 | [哈希表 + 链表 + 优先队列（经典多路归并问题）（Java）](https://leetcode-cn.com/problems/design-twitter/solution/ha-xi-biao-lian-biao-you-xian-dui-lie-java-by-liwe/) |
| 4 月 14 日   | [445. 两数相加 II](https://leetcode-cn.com/problems/add-two-numbers-ii/) | 中等 | []()                                                         |
| 4 月 15 日   | [542. 01 矩阵](https://leetcode-cn.com/problems/01-matrix/)  | 中等 | []()                                                         |
| 4 月 16 日   | [56. 合并区间](https://leetcode-cn.com/problems/merge-intervals/) | 中等 | [贪心算法（Java）](https://leetcode-cn.com/problems/merge-intervals/solution/tan-xin-suan-fa-java-by-liweiwei1419-3/) |
| 4 月 17 日   | [55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)  | 中等 | []()                                                         |
| 4 月 18 日   | [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water) |      |                                                              |
| 4 月 19 日   | [466. 统计重复个数](https://leetcode-cn.com/problems/count-the-repetitions/) | 困难 | [暴力解法 + 优化解法（Java 代码）](https://leetcode-cn.com/problems/count-the-repetitions/solution/bao-li-jie-fa-you-hua-jie-fa-java-dai-ma-by-liweiw/) |
| 4 月 20 日   | [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/) | 中等 | [DFS + BFS + 并查集（Python 代码、Java 代码）](https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/) |
| 4 月 21 日   | [1248. 统计「优美子数组」](https://leetcode-cn.com/problems/count-number-of-nice-subarrays/) | 中等 | []()                                                         |
| 4 月 22 日   | [199. 二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/) | 中等 | []()                                                         |
| 4 月 23 日   | [面试题 08.11. 硬币](https://leetcode-cn.com/problems/coin-lcci/) | 中等 | []()                                                         |
| 4 月 24 日   | [面试题51. 数组中的逆序对](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/) | 困难 | [视频讲解](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/)、[暴力解法、分治思想、树状数组](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/bao-li-jie-fa-fen-zhi-si-xiang-shu-zhuang-shu-zu-b/) |
| 4 月 25 日   | [46. 全排列](https://leetcode-cn.com/problems/permutations)  | 中等 | []()                                                         |
| 4 月 26 日   | [23. 合并K个排序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists) | 中等 | []()                                                         |
| 4 月 27 日   | [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array) | 中等 | []()                                                         |
| 4 月 28 日   | [数组中数字出现的次数](https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof) | 中等 | []()                                                         |
| 4 月 29 日   | [1095. 山脉数组中查找目标值](https://leetcode-cn.com/problems/find-in-mountain-array/) | 中等 | []()                                                         |
| 4 月 30 日   | [快乐数](https://leetcode-cn.com/problems/happy-number)      | 中等 | []()                                                         |

## 「力扣」2020 年 5 月每日一题做题记录

| 日期      | 题目                                                         | 难度 | 题解 |
| --------- | ------------------------------------------------------------ | ---- | ---- |
| 5 月 1 日 | [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists) | 简单 |      |
| 5 月 2 日 | [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters) | 中等 |      |
| 5 月 3 日 | [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray) | 中等 |      |
| 5 月 4 日 | [45. 跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii) | 困难 |      |
| 5 月 5 日 | [98. 验证二叉搜索树](https://leetcode-cn.com/problems/validate-binary-search-tree) | 中等 |      |
| 5 月 6 日 | [983. 最低票价](https://leetcode-cn.com/problems/minimum-cost-for-tickets) | 中等 |      |

## 我在「力扣」圈子里回答的问题

[刷题刷到绝望该怎么办？](https://leetcode-cn.com/circle/discuss/xFI0Il/view/ReA0Nq/)

[大家使用什么样的刷题策略？](https://leetcode-cn.com/circle/discuss/wgBYj3/view/Rz1g5s/)

[在java和c#中A[m-1\]=A[m-- - 1];而在C中A[m-1]!=A[m-- - 1];](https://leetcode-cn.com/circle/discuss/FNDDj1/view/5vanNC/)

[应届生选择大厂还是创业公司](https://leetcode-cn.com/circle/discuss/LG5laG/view/4kh1Wh/)

[小白来请教怎么学习算法](https://leetcode-cn.com/circle/discuss/CQu45C/view/tvdg5X/)

[对于工作党来说，刷题的意义除了面试，还有什么?](https://leetcode-cn.com/circle/discuss/QXnn1F/view/efegCA/)

[如何写好题解？](https://leetcode-cn.com/circle/discuss/VuqJk1/view/HqlaSu/)

[大家都是如何刷 LeetCode 的？](https://leetcode-cn.com/circle/discuss/nRXySQ/view/if4vpv/)

## 题解分类（正在更新）

### 排序

「力扣」第 912 题：[排序数组](https://leetcode-cn.com/problems/sort-an-array/) 的题解：[复习基础排序算法（Java）](https://leetcode-cn.com/problems/sort-an-array/solution/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419/)总结了排序问题的一些要点和学习资料，可以从排序问题开始学习算法。

### 数组

> 数组的问题可以作为「新手场」，因为这些问题只需要掌握编程语言的基础知识就可以完成。

以下这些问题都是很容易想到思路的问题，即使没有学习过相关的数据结构和算法知识。

| 题目序号                                                     | 题解                                                         | 知识点                                     | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------ | ---- |
| [26. 删除排序数组中的重复项（简单）](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array) |                                                              |                                            |      |
| [27. 移除元素（简单）](https://leetcode-cn.com/problems/remove-element/) |                                                              |                                            |      |
| [66. 加一（简单）](https://leetcode-cn.com/problems/plus-one/) |                                                              | 常规问题，纯粹考察编程基本功。             |      |
| [88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/) | [从后向前归并](https://leetcode-cn.com/problems/merge-sorted-array/solution/si-xiang-mei-you-chuang-xin-de-di-fang-zhu-yao-ti-/) | 常规操作，常考问题，注意这里从后向前归并。 |      |
| [189. 旋转数组](https://leetcode-cn.com/problems/rotate-array/) |                                                              | 记住这个旋转三次的操作。                   |      |
| [215. 数组中的第K个最大元素（中等）](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/) |                                                              | 很常见的问题，多次出现，一定要掌握。       |      |
| [451. 根据字符出现频率排序（中等）](https://leetcode-cn.com/problems/sort-characters-by-frequency) |                                                              | 和排序相关的经典问题，做法不唯一。         |      |
| [912. 排序数组（中等）](https://leetcode-cn.com/problems/sort-an-array) |                                                              | 可以用于学习排序问题。                     |      |

#### 循环不变量

> 循环不变量用于证明算法的有效性，也是编码正确的理论依据。
>
> 循环不变量定义帮助分清先加还是先赋值，还有一些边界条件。定义清楚循环不变量以后，代码的编写就会很轻松。
>
> 建议把「循环不变量」作为注释写在代码里，以方便自己调试和他人阅读。

| 题目序号                                                     | 题解                                                         | 知识点                                         | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ---------------------------------------------- | ---- |
| [26. 删除排序数组中的重复项（简单）](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array) |                                                              |                                                |      |
| [27. 移除元素（简单）](https://leetcode-cn.com/problems/remove-element/) |                                                              |                                                |      |
| [75. 颜色分类（中等）](https://leetcode-cn.com/problems/sort-colors/) | [快速排序 partition 过程（重点在设计循环不变量）](https://leetcode-cn.com/problems/sort-colors/solution/kuai-su-pai-xu-partition-guo-cheng-she-ji-xun-huan/) | 著名的「荷兰国旗」问题。                       |      |
| [215. 数组中的第K个最大元素（简单）](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/) | [通过 partition 减治 + 优先队列](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/) | **常考的高频问题，一定要会做，重点掌握思想。** |      |
| [283. 移动零（简单）](https://leetcode-cn.com/problems/move-zeroes) |                                                              | 掌握循环不变式，编写代码更加容易。             |      |

### 双指针

> 「双指针」问题其实来自于最朴素算法的优化，一下子排序掉很多不符合题意的解，「滑动窗口」技巧也是这样的。

| 题目序号                                                     | 题解                                                         | 知识点 | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ---- |
| [11. 盛最多水的容器（中等）](https://leetcode-cn.com/problems/container-with-most-water) |                                                              |        |      |
| [15. 三数之和（中等）](https://leetcode-cn.com/problems/3sum) |                                                              |        |      |
| [16. 最接近的三数之和（中等）](https://leetcode-cn.com/problems/3sum-closest/) | [双指针对撞](https://leetcode-cn.com/problems/3sum-closest/solution/shuang-zhi-zhen-dui-zhuang-python-dai-ma-java-dai-/) |        |      |
| [42. 接雨水（困难）](https://leetcode-cn.com/problems/trapping-rain-water/) | [暴力解法、以空间换时间、双指针、单调栈](https://leetcode-cn.com/problems/trapping-rain-water/solution/bao-li-jie-fa-yi-kong-jian-huan-shi-jian-zhi-zhen-/) |        |      |
| [167. 两数之和 II - 输入有序数组（简单）](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/) | [双指针对撞 + 二分法](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/shuang-zhi-zhen-dui-zhuang-er-fen-fa-python-dai-ma/) |        |      |

### 滑动窗口

+ 滑动窗口写法。

```java
public class Solution {

    public String minWindow(String s, String t) {
        // 起始的时候，都位于 0，同方向移动
        int left = 0;
        int right = 0;
        while (right < sLen) {
            if ( 在右移的过程中检测是否满足条件 ) {
                // 对状态做修改，好让程序在后面检测到满足条件
            }
            // 右边界右移 1 格
            right++;
            while ( 满足条件 ) {
                // 走到这里是满足条件的，左边界逐渐逐渐左移，可以取最小值
                if ( 在左移的过程中检测是否不满足条件 ) {
                    // 对状态做修改，好让程序在后面检测到不满足条件
                }
                // 左边界左移 1 格
                left++;
            }
            // 走到这里是不满足条件的，右边界逐渐右移，可以取最大值
        }
        return 需要的结果变量;
    }
}
```

练习题：

| 题目序号                                                     | 题解 | 知识点           | 代码 |
| ------------------------------------------------------------ | ---- | ---------------- | ---- |
| [3. 无重复字符的最长子串（中等）](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters) |      | 非常经典的问题。 |      |
| [76. 最小覆盖子串（困难）](https://leetcode-cn.com/problems/minimum-window-substring) |      | 非常经典的问题。 |      |
| [209. 长度最小的子数组（中等）](https://leetcode-cn.com/problems/minimum-size-subarray-sum) |      | 非常经典的问题。 |      |
| [239. 滑动窗口最大值（中等）](https://leetcode-cn.com/problems/sliding-window-maximum) |      |                  |      |
| [424. 替换后的最长重复字符（中等）](https://leetcode-cn.com/problems/longest-repeating-character-replacement) |      |                  |      |
| [567. 字符串的排列（中等）](https://leetcode-cn.com/problems/permutation-in-string) |      |                  |      |
| [643. 子数组最大平均数 I（简单）](https://leetcode-cn.com/problems/maximum-average-subarray-i) |      |                  |      |
| [978. 最长湍流子数组（中等）](https://leetcode-cn.com/problems/longest-turbulent-subarray) |      |                  |      |
| [992. K 个不同整数的子数组（困难）](https://leetcode-cn.com/problems/subarrays-with-k-different-integers) |      |                  |      |

### 链表

| 题目序号                                                     | 题解                                                         | 知识点   |
| ------------------------------------------------------------ | ------------------------------------------------------------ | -------- |
| [61. 旋转链表](https://leetcode-cn.com/problems/rotate-list/) | [穿针引线](https://leetcode-cn.com/problems/rotate-list/solution/chuan-zhen-yin-xian-by-liweiwei1419/) | 穿针引线 |

下面的两题考察了「双向链表」的应用。

| 题目                                                         | 难度 | 题解                                                         |
| ------------------------------------------------------------ | ---- | ------------------------------------------------------------ |
| [460. LFU缓存](https://leetcode-cn.com/problems/lfu-cache/)  | 困难 | [哈希表 + 双向链表（Java）](https://leetcode-cn.com/problems/lfu-cache/solution/ha-xi-biao-shuang-xiang-lian-biao-java-by-liweiwei/) |
| [146. LRU缓存机制](https://leetcode-cn.com/problems/lru-cache/) | 中等 | [哈希表 + 双向链表（Java）](https://leetcode-cn.com/problems/lru-cache/solution/ha-xi-biao-shuang-xiang-lian-biao-java-by-liweiw-2/) |

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

#### 栈

| 题目序号                                                     | 题解                                                         | 知识点   | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | -------- | ---- |
| [20. 有效的括号（简单）](https://leetcode-cn.com/problems/valid-parentheses) |                                                              |          |      |
| [71. 简化路径（中等）](https://leetcode-cn.com/problems/simplify-path) |                                                              |          |      |
| [155. 最小栈（简单）](https://leetcode-cn.com/problems/min-stack) |                                                              |          |      |
| [225. 用队列实现栈（简单）](https://leetcode-cn.com/problems/implement-stack-using-queues/) | [负负得正，peek 和 pop 时，依次将队首元素出队，放到队尾](https://leetcode-cn.com/problems/implement-stack-using-queues/solution/peek-he-pop-shi-yi-ci-jiang-dui-shou-yuan-su-chu-d/) |          |      |
| [232. 用栈实现队列（简单）](https://leetcode-cn.com/problems/implement-queue-using-stacks) |                                                              |          |      |
| [284. 顶端迭代器（中等）](https://leetcode-cn.com/problems/peeking-iterator) |                                                              |          |      |
| [316. 去除重复字母（困难）](https://leetcode-cn.com/problems/remove-duplicate-letters/) | [栈 + 哨兵技巧（Java、C++、Python）](https://leetcode-cn.com/problems/remove-duplicate-letters/solution/zhan-by-liweiwei1419/) | 穿针引线 |      |
| [341. 扁平化嵌套列表迭代器（中等）](https://leetcode-cn.com/problems/flatten-nested-list-iterator) |                                                              |          |      |
| [946. 验证栈序列（中等）](https://leetcode-cn.com/problems/validate-stack-sequences) |                                                              |          |      |
| [1111. 有效括号的嵌套深度（中等）](https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/) | [嵌套深度 = 完成括号匹配问题实际使用的栈的最大高度](https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/solution/qian-tao-shen-du-wan-cheng-gua-hao-pi-pei-wen-ti-s/) |          |      |
#### 单调栈

| 序号 | 题目                                                         | 题解                                                         |
| ---- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | [739. 每日温度（中等）](https://leetcode-cn.com/problems/daily-temperatures/) | [【程序员的自我修养】739. Daily Temperatures](https://leetcode-cn.com/problems/daily-temperatures/solution/cheng-xu-yuan-de-zi-wo-xiu-yang-739-daily-temperat/)（我看这篇题解学会的）、[暴力解法 + 单调栈](https://leetcode-cn.com/problems/daily-temperatures/solution/bao-li-jie-fa-dan-diao-zhan-by-liweiwei1419/) |
| 2    | [496. 下一个更大元素 I（简单）](https://leetcode-cn.com/problems/next-greater-element-i/) | [暴力解法、单调栈](https://leetcode-cn.com/problems/next-greater-element-i/solution/bao-li-jie-fa-dan-diao-zhan-by-liweiwei1419-2/) |
| 3    | [503. 下一个更大元素 II（中等）](https://leetcode-cn.com/problems/next-greater-element-ii/) | （我暂时没有写）                                             |
| 4    | [901. 股票价格跨度（中等）](https://leetcode-cn.com/problems/online-stock-span/) | [LeetCode 第 901 题：股票价格跨度（单调栈）](https://blog.csdn.net/lw_power/article/details/103957702) |
| 5    | [84. 柱状图中最大的矩形（困难）](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/) | [暴力解法、栈（哨兵技巧）](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/) |
| 6    | [42. 接雨水（困难）](https://leetcode-cn.com/problems/trapping-rain-water/) | [暴力解法、栈（哨兵技巧）](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/) |

### 队列

| 题目序号                                                     | 题解 | 知识点 | 代码 |
| ------------------------------------------------------------ | ---- | ------ | ---- |
| [621. 任务调度器（中等）](https://leetcode-cn.com/problems/task-scheduler) |      |        |      |
| [622. 设计循环队列（中等）](https://leetcode-cn.com/problems/design-circular-queue) |      |        |      |
| [641. 设计循环双端队列（中等）](https://leetcode-cn.com/problems/design-circular-deque) |      |        |      |
| [1306. 跳跃游戏 III（中等）](https://leetcode-cn.com/problems/jump-game-iii) |      |        |      |

### 优先队列

注意：了解「堆」作为「优先队列」的实现是有必要的，这样才会理解 `remove` 、`replace` 这些编码的细节，使用堆的时候才会更加有效。

| 题目序号                                                     | 题解                                                         | 知识点       | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------ | ---- |
| [215. 数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/) | [通过 partition 减治 + 优先队列（Java、C++、Python）](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/) | 减而治之、堆 |      |
| [295. 数据流的中位数（困难）](https://leetcode-cn.com/problems/find-median-from-data-stream) |                                                              |              |      |
| [347. 前 K 个高频元素（中等）](https://leetcode-cn.com/problems/top-k-frequent-elements) |                                                              |              |      |
| [703. 数据流中的第K大元素（简单）](https://leetcode-cn.com/problems/kth-largest-element-in-a-stream) |                                                              |              |      |
| [973. 最接近原点的 K 个点（中等）](https://leetcode-cn.com/problems/k-closest-points-to-origin) |                                                              |              |      |
| [1296. 划分数组为连续数字的集合（中等）](https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers) |                                                              |              |      |

### 树

（待添加）

### 哈希表

| 题目                                                         | 难度 | 题解                                                         |
| ------------------------------------------------------------ | ---- | ------------------------------------------------------------ |
| [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/) | 中等 | [自定义字符串的哈希规则，使用质数作为乘法因子（Java）](https://leetcode-cn.com/problems/group-anagrams/solution/zi-ding-yi-zi-fu-chuan-de-ha-xi-gui-ze-shi-yong-zh/) |

### 回溯算法

**题型 1**：基本回溯问题，在数组上进行搜索

| 题目序号                                                     | 题解                                                         | 知识点                           | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | -------------------------------- | ---- |
| [46. 全排列（中等）](https://leetcode-cn.com/problems/permutations/) | [从全排列问题开始理解“回溯搜索”算法](https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/) |                                  |      |
| [47. 全排列 II（中等）](https://leetcode-cn.com/problems/permutations-ii/) | [回溯搜索 + 剪枝](https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/) | 理解深度优先遍历，发现剪枝条件。 |      |
| [39. 组合总和](https://leetcode-cn.com/problems/combination-sum/) | [回溯算法 + 剪枝](https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/) | 画树形图。                       |      |
| [40. 组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii/) | [回溯算法 + 剪枝](https://leetcode-cn.com/problems/combination-sum-ii/solution/) | 画树形图。                       |      |
| [78. 子集](https://leetcode-cn.com/problems/subsets/)        | [回溯 + 位掩码](https://leetcode-cn.com/problems/subsets/solution/hui-su-python-dai-ma-by-liweiwei1419/) | 经典问题。                       |      |
| [90. 子集 II](https://leetcode-cn.com/problems/subsets-ii/)  |                                                              | 经典问题。                       |      |
| [77. 组合](https://leetcode-cn.com/problems/combinations/)   | [回溯算法 + 剪枝](https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/) |                                  |      |

**题型 2**：字符串上的回溯问题

重点理解：由于字符串每次都生成新字符，无须状态重置。
| 题目序号                                                     | 题解                                                         | 知识点                                 | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | -------------------------------------- | ---- |
| [17 .电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/) | [回溯搜索（无显式回溯）、广度优先遍历](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/hui-su-sou-suo-wu-xian-shi-hui-su-yan-du-you-xian-/) | 字符串的回溯问题。                     |      |
| [22. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/) | [回溯算法（深度优先遍历）+ 广度优先遍历](https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/) | 字符串的回溯问题。                     |      |
| [93. 复原IP地址](https://leetcode-cn.com/problems/restore-ip-addresses/) | [回溯算法（画图分析剪枝条件）](https://leetcode-cn.com/problems/restore-ip-addresses/solution/hui-su-suan-fa-hua-tu-fen-xi-jian-zhi-tiao-jian-by/) | 字符串的回溯问题。                     |      |
| [784. 字母大小写全排列](https://leetcode-cn.com/problems/letter-case-permutation/) | [在隐式树上做深度优先遍历](https://leetcode-cn.com/problems/letter-case-permutation/solution/shen-du-you-xian-bian-li-hui-su-suan-fa-python-dai/) | 字符串的回溯问题。                     |      |

**题型 3**：二维平面上的回溯问题

| 题目序号                                                     | 题解                                                         | 知识点 | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ---- |
| [79. 单词搜索（中等）](https://leetcode-cn.com/problems/word-search/) | [在二维平面上使用回溯法](https://leetcode-cn.com/problems/word-search/solution/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/) |        |      |

**题型 4**：一些游戏问题
| 题目序号                                                     | 题解                                                         | 知识点 | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ---- |
| [51. N皇后](https://leetcode-cn.com/problems/n-queens/)      | [根据第 46 题“全排列”的“回溯算法”思路编写“N 皇后”问题](https://leetcode-cn.com/problems/n-queens/solution/gen-ju-di-46-ti-quan-pai-lie-de-hui-su-suan-fa-si-/) | 经典问题，掌握「空间换时间」技巧。     |      |
| [37. 解数独（困难）](https://leetcode-cn.com/problems/sudoku-solver/) |  |  | |
| [36. 有效的数独（中等）](https://leetcode-cn.com/problems/valid-sudoku/) |  | 这里用到的是哈希表。 | |

**题型 5**：巧用剪枝

| 题目序号                                                     | 题解                                                         | 知识点 | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ---- |
| [60. 第k个排列](https://leetcode-cn.com/problems/permutation-sequence/) | [深度优先遍历 + 剪枝、双链表模拟](https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/) | 可以基于第 46 题做，剪枝直接来到枝叶。 |      |

### 动态规划

一个「动态规划」问题的分类：https://zhuanlan.zhihu.com/p/126546914?utm_source=wechat_session&utm_medium=social&utm_oi=27134168924160。

知识点讲解：在「力扣」第 5 题[题解](https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/)。

#### 第 1 部分：「动态规划」基本问题

+ 递归 + 记忆化：记忆化递归（记忆化搜索），这是「自上而下」的思路；
+ 掌握「自底向上」递推求解问题的方法；
+ 理解「重复子问题」、「最优子结构」、「无后效性」；
+ 掌握「状态定义」、「状态转移方程」


| 题目序号                                                     | 题解                                                         | 知识点                     | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | -------------------------- | ---- |
| [509. 斐波那契数（简单）](https://leetcode-cn.com/problems/fibonacci-number/) |                                                              | 递归做一定要加缓存。       |      |
| [70. 爬楼梯（简单）](https://leetcode-cn.com/problems/climbing-stairs/) | [CSDN](https://blog.csdn.net/lw_power/article/details/103799112) | 和斐波拉契数是同一道问题。 |      |

#### 第 2 部分：最优子结构


| 题目序号                                                     | 题解                                                         | 知识点 | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ---- |
| [279. 完全平方数（中等）](https://leetcode-cn.com/problems/perfect-squares/) |                                                              |        |      |
| [322. 零钱兑换（中等）](https://leetcode-cn.com/problems/coin-change/) | [动态规划、使用「完全背包」问题思路、图的广度优先遍历](https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/) |        |      |
| [343. 整数拆分（中等）](https://leetcode-cn.com/problems/integer-break/) | [“贪心选择”性质的简单证明、记忆化搜索、动态规划 （Python、Java）](https://leetcode-cn.com/problems/integer-break/solution/tan-xin-xuan-ze-xing-zhi-de-jian-dan-zheng-ming-py/) |        |      |

#### 第 3 部分：无后效性


| 题目序号                                                     | 题解 | 知识点             | 代码 |
| ------------------------------------------------------------ | ---- | ------------------ | ---- |
| [198. 打家劫舍（简单）](https://leetcode-cn.com/problems/house-robber/) |      | 二维状态消除后效性 |      |
| [62. 不同路径（中等）](https://leetcode-cn.com/problems/unique-paths/) |      |                    |      |
| [63. 不同路径 II（中等）](https://leetcode-cn.com/problems/unique-paths-ii/) |      |                    |      |

#### 第 4 部分：经典问题（1）


| 题目序号                                                     | 题解                                                         | 知识点                               | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------ | ---- |
| [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray) | [动态规划、分治法](https://leetcode-cn.com/problems/maximum-subarray/solution/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/)、[CSDN](https://blog.csdn.net/lw_power/article/details/104062895) | 1、经典动态规划问题；2、分治         |      |
| [300. 最长上升子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/) | [动态规划 、贪心算法 + 二分](https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/dong-tai-gui-hua-er-fen-cha-zhao-tan-xin-suan-fa-p/) |                                      |      |
| [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/) | [Manacher 算法 + 动态规划 （Java、C++、Python）](https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/) | 使用动态规划的方法得到子串的回文性质 |      |
| [72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/) | [动态规划（Java）](https://leetcode-cn.com/problems/edit-distance/solution/dong-tai-gui-hua-java-by-liweiwei1419/)、[CDSN](https://blog.csdn.net/lw_power/article/details/103818533) |                                      |      |
| [120. 三角形最小路径和（中等）](https://leetcode-cn.com/problems/triangle/) |                                                              |                                      |      |
| [10. 正则表达式匹配（困难）](https://leetcode-cn.com/problems/regular-expression-matching/) |                                                              |                                      |      |

#### 第 5 部分：经典问题（2）背包问题


| 题目序号                                                     | 题解                                                         | 知识点                         | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------ | ---- |
| [416. 分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/) | [动态规划（0-1 背包问题）](https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/) | 很重要的动态规划模型，必须掌握 |      |
| [518. 零钱兑换 II](https://leetcode-cn.com/problems/coin-change-2/) | [动态规划（套用完全背包问题模型）](https://leetcode-cn.com/problems/coin-change-2/solution/dong-tai-gui-hua-wan-quan-bei-bao-wen-ti-by-liweiw/) |                                |      |
| [322. 零钱兑换（中等）](https://leetcode-cn.com/problems/coin-change/) | [动态规划、使用「完全背包」问题思路、图的广度优先遍历](https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/) |                                |      |
| [377. 组合总和 Ⅳ](https://leetcode-cn.com/problems/combination-sum-iv/) | [动态规划](https://leetcode-cn.com/problems/combination-sum-iv/solution/dong-tai-gui-hua-python-dai-ma-by-liweiwei1419/) |                                |      |
| [494. 目标和](https://leetcode-cn.com/problems/target-sum/)  |                                                              | 0-1 背包问题                   |      |
| [474. 一和零](https://leetcode-cn.com/problems/ones-and-zeroes/) | [动态规划（转换为 0-1 背包问题）](https://leetcode-cn.com/problems/ones-and-zeroes/solution/dong-tai-gui-hua-zhuan-huan-wei-0-1-bei-bao-wen-ti/) |                                |      |

#### 第 6 部分：经典问题（3）股票问题


| 题目序号                                                     | 题解                                                         | 知识点                                                    | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | --------------------------------------------------------- | ---- |
| [121. 买卖股票的最佳时机（简单）](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/) | [暴力枚举 + 动态规划 + 差分思想](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/)、[CSDN](https://blog.csdn.net/lw_power/article/details/103772951) |                                                           |      |
| [122. 买卖股票的最佳时机 II（简单）](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/) | [暴力搜索 + 贪心算法 + 动态规划](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/)、[CSDN](https://blog.csdn.net/lw_power/article/details/103773246) |                                                           |      |
| [123. 买卖股票的最佳时机 III（困难）](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/) | [动态规划](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/dong-tai-gui-hua-by-liweiwei1419-7/)、[CSDN](https://blog.csdn.net/lw_power/article/details/103773822) | 1、从后向前写可以把状态压缩到一维；2、分解成两个 121 题。 |      |
| [188. 买卖股票的最佳时机 IV（困难）](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/) | [动态规划](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/dong-tai-gui-hua-by-liweiwei1419-4/) |                                                           |      |
| [309. 最佳买卖股票时机含冷冻期（中等）](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | [动态规划](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/dong-tai-gui-hua-by-liweiwei1419-5/) |                                                           |      |
| [714. 买卖股票的最佳时机含手续费（中等）](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/) | [动态规划](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/dong-tai-gui-hua-by-liweiwei1419-6/) |                                                           |      |

### 贪心算法

| 题目序号                                                     | 题解 | 知识点 | 代码 |
| ------------------------------------------------------------ | ---- | ------ | ---- |
| [12. 整数转罗马数字（中等）](https://leetcode-cn.com/problems/integer-to-roman) |      |        |      |
| [452. 用最少数量的箭引爆气球（中等）](https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons) |      |        |      |
| [455. 分发饼干（中等）](https://leetcode-cn.com/problems/assign-cookies) |      |        |      |
| [122. 买卖股票的最佳时机 II（简单）](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii) |      |        |      |

### 并查集

#### 第 1 部分：基础且常见的问题

| 题目序号                                                     | 题解                                                         | 知识点 | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ---- |
| [547. 朋友圈（中等）](https://leetcode-cn.com/problems/friend-circles) | [并查集（Python 代码、Java 代码）](https://leetcode-cn.com/problems/friend-circles/solution/bing-cha-ji-python-dai-ma-java-dai-ma-by-liweiwei1/) |        |      |
| [990. 等式方程的可满足性（中等）](https://leetcode-cn.com/problems/satisfiability-of-equality-equations) | [使用并查集处理不相交集合问题](https://leetcode-cn.com/problems/satisfiability-of-equality-equations/solution/shi-yong-bing-cha-ji-chu-li-bu-xiang-jiao-ji-he-we/) |        |      |
| [200. 岛屿数量（中等）](https://leetcode-cn.com/problems/number-of-islands) | [DFS + BFS + 并查集（Python 代码、Java 代码）](https://leetcode-cn.com/problems/number-of-islands/solution/dfs-bfs-bing-cha-ji-python-dai-ma-java-dai-ma-by-l/) |        |      |
| [684. 冗余连接](https://leetcode-cn.com/problems/redundant-connection/) |                                                              |        |      |
| [1319. 连通网络的操作次数（中等）](https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected) | [并查集](https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/solution/bing-cha-ji-by-liweiwei1419/) |        |      |

#### 第 2 部分：带权值的并查集问题

| 题目序号                                                     | 题解                                                         | 知识点 | 代码 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ---- |
| [128. 最长连续序列（困难）](https://leetcode-cn.com/problems/longest-consecutive-sequence) |                                                              |        |      |
| [399. 除法求值（中等）](https://leetcode-cn.com/problems/evaluate-division) |                                                              |        |      |
| [685. 冗余连接 II](https://leetcode-cn.com/problems/redundant-connection-ii/) |                                                              |        |      |
| [721. 账户合并](https://leetcode-cn.com/problems/accounts-merge/) |                                                              |        |      |
| [765. 情侣牵手（困难）](https://leetcode-cn.com/problems/couples-holding-hands) |                                                              |        |      |
| [952. 按公因数计算最大组件大小（困难）](https://leetcode-cn.com/problems/largest-component-size-by-common-factor) | [并查集（Java、Python）](https://leetcode-cn.com/problems/largest-component-size-by-common-factor/solution/bing-cha-ji-java-python-by-liweiwei1419/) |        |      |

## 配套资源

+ 发布在 LeetCode 中文版上的题解配图使用的 PPT，传送门：[https://github.com/liweiwei1419/LeetCode-Solution-PPT](https://github.com/liweiwei1419/LeetCode-Solution-PPT)

说明：做了 PPT 或者动画的题目，一般在 LeetCode 中文版的题解区都能看到我写的题解。

## 刷题过程中形成的文章（待更新）

+ 目前更新在[网站](https://liweiwei1419.gitee.io/leetcode-algo/)。

