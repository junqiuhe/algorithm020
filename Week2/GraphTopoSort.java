
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 拓扑排序的要求图是 有向无环图
 */
public class GraphTopoSort {

    private int v;
    private LinkedList<Integer>[] edge;

    public GraphTopoSort(int v) {
        this.v = v;
        edge = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            edge[i] = new LinkedList<>();
        }
    }

    /**
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        edge[s].add(t);
    }

    /**
     * Kaha --> 贪心算法思想
     * <p>
     * 正向的思考方式.
     */
    public void topoSortByKaha() {
        /**
         * 统计每个顶点的入度
         */
        int[] inDegree = new int[v];

        for (int i = 0; i < v; i++) { //每个顶点
            for (int j = 0; j < edge[i].size(); j++) { //顶点 i 指向的所有顶点.
                int w = edge[i].get(j);
                inDegree[w]++;
            }
        }

        /**
         * 将入度为0的点添加到队列中.
         */
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        /**
         * 依次删除入度为0的节点，并且将与该节点相连的节点的入度-1. 判断与其相连的节点入度为0，将其添加到队列
         */
        while (!queue.isEmpty()) {
            int i = queue.poll();

            System.out.println("--> " + i);

            for (int j = 0; j < edge[i].size(); j++) {
                int k = edge[i].get(j);
                inDegree[k]--;
                if (inDegree[k] == 0) queue.offer(k);
            }
        }
    }

    /**
     * 通过DFS算法 --> 进行拓扑排序（画图理解）
     */
    public void topoSortByDfs() {
        LinkedList<Integer>[] inverseEdge = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            inverseEdge[i] = new LinkedList<>();
        }

        /**
         * 求邻接表的 逆邻接表.
         */
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < edge[i].size(); j++) {
                int k = edge[i].get(j);
                inverseEdge[k].add(i);
            }
        }

        /**
         * 深度优先算法
         */
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, inverseEdge, visited);
            }
        }
    }

    private void dfs(int v, LinkedList<Integer>[] inverseEdge, boolean[] visited) {
        for (int i = 0; i < inverseEdge[v].size(); i++) {
            int w = inverseEdge[v].get(i);
            if (visited[w]) {
                continue;
            }
            visited[w] = true;
            dfs(w, inverseEdge, visited);
        }

        System.out.println("---> " + v);
    }

    public static void main(String[] args) {
        GraphTopoSort graph = new GraphTopoSort(6);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(5, 0);
        graph.addEdge(5, 2);

        graph.topoSortByKaha();
//        graph.topoSortByDfs();
    }
}
