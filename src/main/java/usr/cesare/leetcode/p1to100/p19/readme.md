# LeetCode Solution P19-Remove Nth Node From End of List
经典双指针问题：
    
    使用先后双指针，两个指针的距离差值为N即可
    
```java
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        if(node == null) return null;
        for (int i = 0; i < n; i++) {
            node = node.next;
        }
        if(node == null){
            return head.next;
        }
        ListNode preNode = head;
        while (node.next != null){
            node = node.next;
            preNode = preNode.next;
        }
        preNode.next = preNode.next.next;
        return head;
    }
}
```