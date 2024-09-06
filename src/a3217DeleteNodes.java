import java.util.HashSet;
import java.util.Set;


public class a3217DeleteNodes {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numsSet = new HashSet<>();
        for(int num:nums)
            numsSet.add(num);
        ListNode output = new ListNode();
        ListNode outputHead = output;
        while(head!=null)
        {
            if(!numsSet.contains(head.val))
            {
                output.next = new ListNode(head.val);
                output = output.next;
            }
            head = head.next;
        }
        return outputHead.next;
    }
}
