学习笔记

```
/**
* 树的深度优先遍历算法 与 图的深度优先遍历算法的区别关键在于树不需要记录已经访问过的节点。
因为树本身不存在环的结构，保证在遍历的过程中不会存在重复访问的情况
*/ 
List<Node> visited = new ArrayList();

void dfs(node, visited) {
    //terminator
    if(node in visited){
        return;
    }
    
    visited.add(node);
    
    //process current level logic.
    
    for(Node node: node.children){
        //进入下一层.
        if(node not in visited){
            dfs(node, visited)
        }
    }
}

```

```
//利用的队列先进先出的特点.
List<Node> visited = new ArrayList();

vod bfs(node) {
    if(node == null) return;
    
    Queue<Node> queue = new ArrayQueue<>();
    queue.push(node)
    
    while(!queue.isEmpty()) {
        Node curNode = queue.popFirst();
        
        visited.add(curNode);
        
        for(Node childNode: curNode.children) {
            if(childNode not in visited){
                stack.addLast(childNode);
            }
        }
    }
}

```

```
//二分法代码模版
//1、数组必须有序
//2、存在上下界
//3、必须采用下标的方式访问
public void binarySearch(int nums, int target){
    int left = 0;
    int right = nums.length - 1;
    while(left <= right) {
        int mid = left + (right - left) / 2;
        if(num[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            left = mid;
        }else{
            right = mid - 1;
        }
    }
    return -1;
}
```