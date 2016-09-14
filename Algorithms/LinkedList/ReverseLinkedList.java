
public class ReverseLinkedList {
	ListNode head;
	
	public static void main(String[] args) {
		ReverseLinkedList llist = new ReverseLinkedList();

		llist.push(15);
		llist.push(10);
		llist.push(5);
		llist.push(20);
		llist.push(3);
		llist.push(2);
		
		llist.printList(llist.head);
//		ListNode reverseHead = llist.reverseList(llist.head);
//		System.out.println();
//		llist.printList(reverseHead);
		ListNode reverseHeadRecursion = llist.reverseListRecursive(llist.head);
		System.out.println();
		llist.printList(reverseHeadRecursion);
	}

	public ListNode reverseList(ListNode head) {
		if(head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextTemp = null;
        while(curr != null){
            nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
	
	public ListNode reverseListRecursive(ListNode head) {
	    if(head==null || head.next == null)
	        return head;
	 
	    //get next node    
	    ListNode second = head.next;    
	    
	    // rest keeps pointing to basically the head of the reversed list whereas second 
	    // points to the tail of the reversed list.
	    ListNode rest = reverseListRecursive(second);
	    second.next = head;
	    head.next = null;//set first's next to be null
	 
	    return rest;
	}
	
	/*
	 * Utility Functions.
	 */
	public void push(int data) {
		ListNode newNode = new ListNode(data);
		newNode.next = head;
		head = newNode;
	}

	void printList(ListNode head) {
		ListNode node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

}
