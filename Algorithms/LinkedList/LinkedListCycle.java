
public class LinkedListCycle {
	public static boolean hasCycle(ListNode head) {
		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

			if (slowPtr == fastPtr)
				return true;
		}

		return false;
	}
	
	public static ListNode findCycleNode(ListNode head) {
		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

			if (slowPtr == fastPtr)
				break;
		}

		if(fastPtr == null || fastPtr.next == null){
			return null;
		}
		
		slowPtr = head;
		
		while(slowPtr != fastPtr){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		
		return fastPtr;
	}
}



