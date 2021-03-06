# CAP定理
CAP 定理指出对于一个分布式计算系统，不可能同时满足以下三点。
- Consistency：每次read，都得到最新的写数据，或者一个error。
  - >要么给我最新的写数据，要么给我一个错误。
- Availability：每次请求都可以收到一个（非error）的响应，但不保证是最新的写数据。
  - >一定要给我一个正常的响应，我不关心数据是不是最新。
- Partition tolerance：相当于对通信的时限要求。如果不能在时限内达成数据一致性，意味着发生了分区，必须就当前操作在C和A之间做出选择。
  - 选择C，抛弃A：选择一致性，可能给出错误，也可能给出最新的数据。
  - 选择A，抛弃C：选择可用性，给出正常响应，不知道这个数据是不是最新。

## CAP理论的理解
想象两个节点分处分区两侧：Node1 | Node2
- 如果允许至少一个节点更新状态会导致数据不一致，即丧失了C性质。=> AP
- 如果为了保证数据一致性，将分区一侧的节点设置为不可用，即丧失了A性质。=> CP
- 除非两个节点可以互相通信，才能既保证C又保证A，这会丧失P性质。=> CA
  - 因为不同节点之间同步最新的数据需要一定的时限，如果不能在时限内达成数据一致，那么就意味着发生分区。

## C
- 最终一致性
  - 举例：DNS，域名解析系统。DNS系统生效不是即时的，有一定的延迟。但最终结果而言，是一致的。
