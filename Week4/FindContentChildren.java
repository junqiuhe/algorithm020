
public class FindContentChildren {
/**
     * @param g: 小孩的胃口
     * @param s: 饼干的尺寸
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0;
        int si = 0;

        int count = 0;
        while (gi < g.length && si < s.length) {
            if (s[si] >= g[gi]) {
                si++;
                gi++;
                count++;
            }  else {
                si++;
            }
        }
        return count;
    }
}