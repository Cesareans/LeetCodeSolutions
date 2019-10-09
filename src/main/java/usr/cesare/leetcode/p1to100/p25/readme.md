# LeetCode Solution P25-Reverse Nodes in k-Group
经典链表反转 + K组：
    
    使用head与tail标记交换组别的头与尾，在完成反转后记得链接即可
    
```java
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode fakeHead = new ListNode(0), preHead = fakeHead;
        fakeHead.next = head;

        while (true) {
            int c = 0;
            ListNode tail = head;
            while (tail != null) {
                c++;
                if (c == k) {
                    break;
                }
                tail = tail.next;
            }
            if (c == k) {
                preHead.next = reverse(head, k);
                preHead = head;
                head = head.next;
            } else {
                break;
            }
        }
        return fakeHead.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode p = head, q = head.next, qhead = q;
        for (int i = 1; i < k; i++) {
            qhead = q.next;
            q.next = p;
            p = q;
            q = qhead;
        }
        head.next = qhead;
        return p;
    }
}
```