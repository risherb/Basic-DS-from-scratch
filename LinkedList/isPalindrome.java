public class isPalindrome {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static ListNode curr;

    public static boolean isPalindrome(ListNode head) {
        curr = head;
        return check(head);
    }

    private static boolean check(ListNode head) {
        if (head == null) return true;
        boolean ans = check(head.next);
        if (head.val != curr.val) return false;
        curr = curr.next;
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }
}
