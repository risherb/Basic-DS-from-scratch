public class mergetwosortedarrays{
	static class ListNode{
		int value;
		ListNode next;
		ListNode(int value){
			this.value = value;
			this.next = next;
		}
		
	}
	public static ListNode merge(ListNode list1, ListNode list2){
		if (list1 == null) return list2;
		if (list2 == null) return list1;
		ListNode result;
		if (list2.value > list1.value) {
			result = list1;
			result.next = merge(list1.next,list2);
			
		}
		else{
			result = list2;
			result.next = merge(list1,list2.next);
		}
		return result;
	}
	public static void Print(ListNode result){
		while(result != null){
			System.out.println(result.value);
			result = result.next;
		}
	}
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(5);
		
		
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(4);
		head1.next.next = new ListNode(6);
		
		ListNode result = merge(head,head1);
		Print(result);
	}
	
}