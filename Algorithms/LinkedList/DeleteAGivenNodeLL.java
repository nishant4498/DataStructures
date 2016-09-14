
public class DeleteAGivenNodeLL {
	/* Driver program to test above functions */
	public static void main(String args[]) {
		LinkedList1 llist = new LinkedList1();

		llist.push(15);
		llist.push(10);
		llist.push(5);
		llist.push(20);
		llist.push(3);
		llist.push(2);

		llist.printList(llist.head);
		ListNode head = llist.deleteNode(3);
		System.out.println();
		llist.printList(head);
	}
}

class LinkedList1 {

	ListNode head;

	public ListNode deleteNodeAtPosition(int position) {
		if (head == null)
			return null;
		ListNode temp = head;
		if (position == 0) {
			head = temp.next;
			return head;
		}
		
		for (int i = 0; temp != null && i < position - 1; i++)
			temp = temp.next;
		
		if (temp == null || temp.next == null)
			return null;
		
		ListNode next = temp.next.next;		
		temp.next = next; 
		return head;
	}
	
	public ListNode deleteNode(int value) {
		if (head == null)
			return null;
		ListNode temp = head;
		if (head.data == value) {
			head = temp.next;
			return head;
		}
		
		while(temp.next != null && temp.next.data != value)
			temp = temp.next;
		
		if (temp == null || temp.next == null)
			return null;
		
		ListNode next = temp.next.next;		
		temp.next = next; 
		return head;
	}

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