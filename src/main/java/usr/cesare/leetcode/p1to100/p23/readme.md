# LeetCode Solution P23-Merge k Sorted Lists
最小堆：Time @ `O(sum(n) * log(k))` Space @ `O(k)`
    
    利用最小堆存储每个链表头节点即可。
    注意Java中的PriorityQueue是使用堆实现的可节省大量代码。
    
```java
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if(node != null){
                minHeap.add(node);
            }
        }

        ListNode head = minHeap.poll(), node = head;
        if (head != null && head.next != null) {
            minHeap.add(head.next);
        }
        while (minHeap.size() > 0) {
            node.next = minHeap.poll();
            node = node.next;
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        return head;
    }
}
```

分治法：Time @ `O(sum(n) * log(k))` Space @ `O(1)`
    
    两个链表为一组进行合并，进行分治合并。
    同时因为不使用额外的数据结构，不仅在空间上效率较高，同时常数因子也非常低

```java
public class Solution{
   public ListNode mergeKLists(ListNode[] lists) {
       if(lists == null || lists.length == 0){
           return null;
       }
       return merge(0, lists.length - 1, lists);
   }

   public ListNode merge(int l, int r, ListNode[] lists){
       if(l == r){
           return lists[l];
       }
       int mid = (l + r) / 2;
       ListNode left = merge(l, mid, lists);
       ListNode right = merge(mid + 1, r, lists);

       ListNode head = new ListNode(0), node = head;
       while (left != null && right != null){
           if(left.val > right.val){
               node.next = right;
               right = right.next;
           }else{
               node.next = left;
               left = left.next;
           }
           node = node.next;
       }
       node.next = left==null?right:left;
       return head.next;
   }
}
```


