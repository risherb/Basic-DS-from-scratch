public class MiddleElement{
	static class ListNode{
		int value;
		ListNode next;
		ListNode(int value){
			this.value = value;
			this.next = null;
		}
		ListNode (int value,ListNode next){
			this.value = value;
			this.next  = next;
			//why did i need this constructor , because 
			//then i can easily make a linkedlist in a single line
			//example : ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(3)));

		}
	}
	public static ListNode middle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;

    }
	
	public static void main(String[] args){
		ListNode head = new ListNode(1,new ListNode(2, new ListNode(3)));
		ListNode ans = middle(head);
		System.out.print(ans.value);
		
	}
}