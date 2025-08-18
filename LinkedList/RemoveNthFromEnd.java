public class RemoveNthFromEnd{
	static class ListNode{
		int value;
		ListNode next;
		ListNode(int value){
			this.value = value;
			this.next = null;
		}
		ListNode(int value, ListNode next){
			this.value = value;
			this.next = next;
		}
	}
	public static ListNode remove(ListNode head, int n){
		ListNode dummy = new ListNode (-1);
        dummy.next = head;

        ListNode f = dummy;
        ListNode s = dummy;

        for (int i=0; i<n ; i++){
            f = f.next;
        }
        while (f.next != null) {
            f=f.next;
            s=s.next;
        }
        s.next = s.next.next;
        return dummy.next;
		
	}
	public static void main(String[] args){
		ListNode newHead = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4))));
		int n = 2;
		remove(newHead,n);
		System.out.println(newHead.value + " " + newHead.next.value + " " + newHead.next.next.value);
	}
}