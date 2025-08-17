public class reverselinkedlist{
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
			this.next = null;
		}
	}
	public static ListNode IterativeReverse(ListNode head){
		ListNode curr = head;
		ListNode prev = null;
		while (curr != null){
		ListNode temp = curr.next;
		curr.next = prev;
		prev = curr;
		curr = temp;
		}
		return prev;
		
	}
	public static ListNode RecursiveReverse(ListNode head){
		if (head == null || head.next == null) return head;
		ListNode last = RecursiveReverse(head.next);
		head.next.next = head;
		head.next = null;
		return last;
	}
	public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
	 public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);
		head = IterativeReverse(head);
		System.out.println("\nIterative List:");
		printList(head);
		head = RecursiveReverse(head);
		System.out.println("\nRecursive List:");
		printList(head);
	 }
	
	
	
	
	
}