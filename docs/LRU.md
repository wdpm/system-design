# LRU
一种缓存驱逐策略，当缓存满时将最近最少使用的元素删除。

## 实现原理
- 数据结构表示：double linked list + hash map(key,value) + size
  - hash map：使用key获取cache中的value，时间复杂度O(1)。
  - double linked list：hash map中的value就是double linked list类型。根据双向链表的性质，头部和尾部都可以较快访问。
- 特征：最近使用的元素会移动到头部，相反，最近最少使用的元素会逐步移动到末尾。

假设一个key被访问，有两种情况：
- 该key已存在于cache中，即缓存命中，将这个key关联的元素移动到list头部。
- 该key未存在于cache中，即缓存未命中，将这个key关联的元素添加到list。此时分两种情况：
  - 如果缓存未满，将这个元素添加到list头部。
  - 如果缓存已满，删除list最后一个节点，将这个元素添加list头部。

## 编码实现
>TODO