//方式一、利用 LinkedHashMap

// public class LRUCache extends LinkedHashMap<Integer, Integer> {

//     private int capacity;

//     public LRUCache(int capacity) {
//         super(capacity, 0.75f, true);
//         this.capacity = capacity;
//     }

//     public int get(int key) {
//         return getOrDefault(key, -1);
//     }

//     public void put(int key, int value) {
//         super.put(key, value);
//     }

//     @Override
//     protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//         return size() > capacity;
//     }
// }


/**
 * 方式二、Hash表 + 双向链表
 */
public class LRUCache {

    private HashMap<Integer, DLinkedNode> cache;

    private int capacity;
    private int size;

    private DLinkedNode head = new DLinkedNode();
    private DLinkedNode tail = new DLinkedNode();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        cache = new HashMap<>();

        //使用伪头部和伪尾部节点
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        //将其放到链表头部节点
        removeNode(node);
        addNodeToHead(node);

        return node.value;
    }

    public void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addNodeToHead(DLinkedNode node) {
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            node.value = value;

            //将其放到链表头部节点
            removeNode(node);
            addNodeToHead(node);
            return;
        }

        node = new DLinkedNode(key, value);
        addNodeToHead(node);
        cache.put(key, node);
        size++;
        if (size > capacity) {
            DLinkedNode tail = removeTail();
            cache.remove(tail.key);
            size--;
        }
    }

    private static class DLinkedNode {
        int key;
        int value;

        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}