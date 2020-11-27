
/**
* 图的遍历算法（DFS、BFS）
*/
public class Graph {


/**
 * 采用邻接表数据结构表示图.
 */

    /**
     * 顶点的个数
     */
    private int v;

    /**
     * 记录与相应顶点相连的顶点.
     */
    private LinkedList<Integer>[] edge;

    public Graph(int v) {
        this.v = v;
        this.edge = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            edge[i] = new LinkedList<>();
        }
    }

    /**
     * @param s: 顶点
     * @param t: 顶点
     */
    public void addEdge(int s, int t) {  //无向图.
        edge[s].add(t);
        edge[t].add(s);
    }

    /**
     * 广度优先遍历
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }

        boolean[] visited = new boolean[v];
        visited[s] = true;

        /**
         * 记录访问的路径 prev[i]  --> 表示节点 i 的上一个节点是是 prev
         */
        int[] prev = new int[v];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = -1;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            /**
             * 获取与当前节点相连所有节点.
             */
            for (int i = 0; i < edge[cur].size(); i++) {
                int v = edge[cur].get(i);
                if (!visited[v]) {
                    prev[v] = cur;
                    if (v == t) {
                        print(prev, s, t);
                        return;
                    }

                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    /**
     * 深度优先遍历.
     *
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[v];

        /**
         * prev[i] 记录的是 i 的上一个节点。
         */
        int[] prev = new int[v];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = -1;
        }
        recursiveDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private boolean found = false;

    private void recursiveDfs(int s, int t, boolean[] visited, int[] prev) {
        if (found) return;
        visited[s] = true;

        if (s == t) {
            found = true;
            return;
        }

        for (int i = 0; i < edge[s].size(); i++) {
            int q = edge[s].get(i);

            if (!visited[q]) {
                prev[q] = s;
                recursiveDfs(q, t, visited, prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        /**
         * prev[t] --> 表示t的上一个节点.
         */
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);

//        graph.bfs(0, 7);
        graph.dfs(0, 7);
    }
}
