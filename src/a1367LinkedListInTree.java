public class a1367LinkedListInTree {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null)
            return true;
        if(root==null)
            return false;
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);

    }
    public boolean dfs(ListNode lCurrent, TreeNode tCurrent)
    {
        if(lCurrent==null)
            return true;
        if(tCurrent==null)
            return false;
        if(lCurrent.val!=tCurrent.val)
            return false;
        return dfs(lCurrent.next, tCurrent.left) || dfs(lCurrent.next, tCurrent.right);
    }
    public static void main(String[] args) {
        a1367LinkedListInTree obj = new a1367LinkedListInTree();
        ListNode head = obj.new ListNode(4);
        head.next = obj.new ListNode(2);
        head.next.next = obj.new ListNode(8);
        TreeNode root = obj.new TreeNode(1);
        root.left = obj.new TreeNode(4);
        root.left.right = obj.new TreeNode(2);
        root.left.right.left = obj.new TreeNode(1);
        root.right = obj.new TreeNode(4);
        root.right.left = obj.new TreeNode(2);
        root.right.left.left = obj.new TreeNode(6);
        root.right.left.right = obj.new TreeNode(8);
        root.right.left.right.left = obj.new TreeNode(1);
        root.right.left.right.right = obj.new TreeNode(3);
        System.out.println(obj.isSubPath(head, root));
    }
}
