public class a0725SplitLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        class Solution {
            public ListNode[] splitListToParts(ListNode head, int k) {
                int listLength = getLength(head);
                int partSize = listLength/k;
                int rest = listLength%k;
                ListNode[] parts = new ListNode[k];
                ListNode current = head;
                for(int i = 0; i<k && current!=null; i++)
                {
                    parts[i] = current;
                    int partLength = partSize + (i<rest?1:0);
                    for(int j = 1; j<partLength; j++)
                    {
                        current = current.next;
                    }
                    ListNode next = current.next;
                    current.next = null;
                    current = next;
                }
                return parts;
            }
            private int getLength(ListNode head)
            {
                if(head == null)
                    return 0;
                int length = 1;
                ListNode current = head;
                while(current.next!=null)
                {
                    length++;
                    current = current.next;
                }
                return length;
            }
        }
    }
}
