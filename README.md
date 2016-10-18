# Algorithms
每天写点算法。

所有算法的测试用例在[Main.java](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/main/Main.java)中，运行这个文件便可以看到结果。

##二叉树遍历（递归与非递归）

2016年5月18日

[前序遍历](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/PreOrderTraversal.java)

[中序遍历](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/InOrderTraversal.java)

[后序遍历](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/PostOrderTraversal.java)

##八皇后（回溯法）

2016年5月19日

[八皇后](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/EightQueensPuzzle.java)

##二叉排序树

2016年5月20日

[二叉排序树](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/BinarySearchTree.java)

##二叉树的高度（递归和非递归）

2016年5月21日

初中开始编程，之前很擅长递归变非递归。这两年算法题几乎没怎么做，所以最近自己多写写。

个人觉得非递归算法很有意思，校招迅雷的时候，跟面试官将了一下怎么将递归变非递归，当时他觉得太牛了。

很多人会觉得我代码太复杂，尤其昨天BST节点删除的代码估计很多人看了会吐血。我写算法一般不看别人的代码，完全是自己理解后写的，是适合自己的。我觉得时间复杂度都差不多，最多差个常数，所以代码复杂点无所谓。何况我自己写算法只是想保持思维，不是想考ACM。

[二叉树的高度](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/BinaryTreeHeight.java)

##并查集

2016年5月22日

[并查集](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/DisjointSet.java)

##骑士巡游（递归和非递归）

2016年5月23日

[骑士巡游](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/KnightCruise.java)

##阿克曼函数（Ackermann function）递归与非递归

2016年5月24日

[Ackermann function](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/AckermannFunction.java)

##快速排序（递归与非递归）

2016年5月25日

自虐一番，写一个非递归快速排序，这次用state表示递归函数执行到的地方，并且将需要用到的临时变量i保存在stack中。

估计不会有人蛋疼地写一个非递归快排，呵呵！

我觉得非递归先放一下啦，还有好多算法要温习，所以最近暂时不写非递归了。

[非递归快速排序](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/QuickSort.java)

##八数码问题（九宫格问题）

2016年5月26日

这次练一下BFS，下次用A*解决问题。

[八数码问题](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/EightDigitMaze.java)

##双向链表

2016年5月27日

好久不写双向链表了，今天写一个。

[双向链表](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/DoublyLinkedList.java)

##基于双栈的计算器

2016年5月28日

这是一道老题目。

[基于双栈的计算器](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/DoubleStackBasedCalculator.java)

##拓扑排序

2016年5月29日

[拓扑排序](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/TopologicalSort.java)

##24点游戏

2016年5月30日

这个题目高中的时候用DFS做了好久。

现在尝试BFS，二十分钟就写好了，感觉自己现在写代码真的比高中的时候快好多。

做得比较吊的地方是输出的表达式是严格简化过的，不会出现多余括号。

[24点游戏](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/TwentyFourGame.java)

##蛇形矩阵

2016年5月31日

纯自虐，写出了数学公式来解决蛇形矩阵，给出位置就可以用公式计算值。

具体推导过程见代码的注释部分。

[蛇形矩阵](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/SnakeMatrix.java)

##野人传教士过河

2016年6月1日

设有3个传教士（Missionaries）和3个野人(Cannibals)来到河边，打算乘一只船从右岸渡到左岸去。
该船的最大负荷能力为两个人（k=2）。在任何情况下：如果野人人数超过传教士人数，那么野人就会把传教士吃掉。
他们怎样才能用这条船安全地把所有人都渡过河去呢？

网上有人用dfs，这不很明显应该用bfs吗？？？

好忧伤的六一儿童节！！！

[野人传教士过河](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/MissionariesAndCannibalsProblem.java)

##Equal sum

2016年6月2日

不知道怎么说这个题。

[EqualSum](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/EqualSum.java)

##Find first in array

2016年6月3日

[FindFirstInArray](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/FindFirstInArray.java)

##Prim

2016年6月4日

[Prim](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/Prim.java)

##Kruskal

2016年6月5日

[Kruskal](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/Kruskal.java)

##Dijkstra

2016年6月6日

[Dijkstra](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/Dijkstra.java)

##二叉树宽度

2016年6月7日

[二叉树宽度](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/BinaryTreeWidth.java)

##二叉树最大分数

2016年6月8日

[二叉树最大分数](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/problem/BinaryTreeMaxScore.java)

##二叉树前中转后序遍历

2016年6月9日

[二叉树前中转后序遍历](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/problem/PreOrderInOrderToPostOrder.java)

##二叉树前后转中序遍历

2016年6月10日

[二叉树前后转中序遍历](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/problem/PreOrderPostOrderToInOrder.java)

##二叉树后中转前序遍历

2016年6月11日

[二叉树后中转前序遍历](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/problem/InOrderPostOrderToPreOrder.java)

##二分查找

2016年6月12日

[二分查找](https://github.com/Xiaofei-it/Algorithms/blob/master/algorithms/src/main/java/xiaofei/algorithm/BinarySearch.java)

So busy recently!
