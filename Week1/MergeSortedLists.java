/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * 迭代的方式 ---> 自己写的比较挫的代码.
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = null;
        ListNode cur = null;

        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while (cur1 != null && cur2 != null) {
            if (cur1.val > cur2.val) {
                if (cur == null) {
                    cur = cur2;
                    h = cur2;
                } else {
                    cur.next = cur2;
                    cur = cur.next;
                }
                cur2 = cur2.next;
            } else {
                if (cur == null) {
                    cur = cur1;
                    h = cur1;
                } else {
                    cur.next = cur1;
                    cur = cur.next;
                }
                cur1 = cur1.next;
            }
        }

        while (cur1 != null) {
            if (cur == null) {
                cur = cur1;
                h = cur1;
            } else {
                cur.next = cur1;
                cur = cur.next;
            }
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            if (cur == null) {
                cur = cur2;
                h = cur2;
            } else {
                cur.next = cur2;
                cur = cur.next;
            }
            cur2 = cur2.next;
        }

        return h;
    }

    /**
     * 优化后的代码（技巧：添加一个头节点。）
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h1 = new ListNode(-1);
        ListNode cur = h1;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return h1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
