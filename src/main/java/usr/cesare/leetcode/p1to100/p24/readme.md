# LeetCode Solution P24-Swap Nodes in Pairs
经典链表问题：
    
    非常简单的题目，注意使用链表节点即可

```java
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode resHead = head;
        if(resHead == null) return null;
        if(head.next != null){
            resHead = head.next;
            head.next = resHead.next;
            resHead.next = head;
        }
        ListNode pre = head, post = head.next;
        while (post != null && post.next != null){
            pre.next = post.next;
            post.next = pre.next.next;
            pre.next.next = post;
            pre = post;
            post = post.next;
        }
        return resHead;
    }
}
```