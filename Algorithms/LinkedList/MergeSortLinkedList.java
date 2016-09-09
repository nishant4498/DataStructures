
public class MergeSortLinkedList {
	/* Driver program to test above functions */
    public static void main(String args[])
    {
        LinkedList llist = new LinkedList();
 
        llist.push(15);
        llist.push(10);
        llist.push(5);
        llist.push(20);
        llist.push(3);
        llist.push(2);
 
        llist.head = llist.mergeSort(llist.head);
        llist.printList(llist.head); 
    }
}

class LinkedList{
 
    Node head;  // head of list
 
    Node mergeSort(Node head){
        /* Base case -- length 0 or 1 */
        if(head == null || head.next == null){
            return head;
        }
        //get middle node for Split head into 'a' and 'b' sublists 
        Node mid = getMidNode(head);
 
        Node a = head;//firstList
        Node b = mid.next;//secondList
        mid.next = null;
 
        /* Recursively sort the sublists */
        mergeSort(a);
        mergeSort(b);
 
        /* answer = merge the two sorted lists together */
        head = SortedMerge(a,b);
 
        return head;
    }
    
    Node getMidNode(Node head){
        Node slow = head;
        Node fast = head.next;
 
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
 
    Node SortedMerge(Node a,Node b){
        Node result = null;
        /* Base cases */
        if (a == null) 
            return(b);
        else if (b == null) 
            return(a);
 
        /* Pick either a or b, and recur */
        if (a.data <= b.data) {
            result = a;
            result.next = SortedMerge(a.next, b);
        }
        else{
            result = b;
            result.next = SortedMerge(a, b.next);
        }
       
        return(result);
}
 
 
 
    
    public void push(int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }    
   
    void printList(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }    
} 