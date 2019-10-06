package usr.cesare.leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode build(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        ListNode ln = new ListNode(nums[0]), head = ln;
        for(int i = 1 ; i < nums.length; ++i){
            ln.next = new ListNode(nums[i]);
            ln = ln.next;
        }
        return head;
    }

    public void print(){
        System.out.print(val);
        ListNode n = next;
        while (n != null){
            System.out.print("->" + n.val);
            n = n.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("" + val);
        ListNode n = next;
        while (n != null){
            stringBuilder.append("->").append(n.val);
            n = n.next;
        }
        return stringBuilder.toString();
    }
}
