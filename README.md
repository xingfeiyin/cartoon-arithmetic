# cartoon-arithmetic

《漫画算法》相关代码示例与学习笔记，用 Java 把常见算法题、排序算法和实际应用场景写成可以运行、可以拆解的示例。

这个项目适合正在学习数据结构与算法、准备面试、或者想用 Java 复习经典算法思路的人。

## 项目内容

### 面试题与算法题

- 大整数相加
- 寻找缺失整数
- 寻找全排列的下一个数
- 最大公约数
- 链表是否有环
- 最大相邻差
- 最小栈
- 判断 2 的整数次幂
- 删除 K 个数字后的最小值
- 用栈实现队列

### 排序算法

- 冒泡排序
- 鸡尾酒排序
- 快速排序
- 堆排序
- 计数排序
- 桶排序

### 实际应用

- A* 寻路
- LRU 缓存
- 位图
- 红包随机分配

## 如何运行

项目使用 Java 8 和 Maven。

```bash
./mvnw test
```

也可以直接在 IDE 中打开项目，运行各个示例类中的 `main` 方法。

## 目录说明

```text
src/main/java/com/yinxf/arithmetic
├── interview      # 面试题和经典算法题
├── practicaluse   # 算法的实际应用
├── sort           # 排序算法
└── tree           # 树相关内容
```

## 适合怎么学

1. 先读代码里的题目说明，理解问题要解决什么。
2. 自己先想一种直接做法，再看示例实现。
3. 修改输入数据，观察输出变化。
4. 补充边界情况，例如空数据、重复数据、极大数字等。
5. 尝试把代码改写成自己更熟悉的写法。

## 贡献方式

欢迎提交改进：

- 补充 README 中缺少的题目索引
- 给现有示例增加测试用例
- 修复边界情况
- 增加更清晰的注释
- 补充新的算法示例
- 增加英文说明，帮助更多人阅读

提交前建议先看 [CONTRIBUTING.md](CONTRIBUTING.md)。

## Roadmap

后续计划见 [ROADMAP.md](ROADMAP.md)。

## 更多资料

- [English README](README_EN.md)
- [算法索引](docs/ALGORITHM_INDEX.md)
- [维护计划](docs/MAINTENANCE_PLAN.md)
- [增长清单](docs/GROWTH_CHECKLIST.md)

## License

本项目使用 MIT License。
