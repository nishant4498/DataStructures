
public class LinkedListBinaryToDec {

	public static long TestMyCode(ListNode head) {
		// TODO Auto-generated constructor stub
		String number = "";	
		ListNode temp = head;
		while(temp.next != null){
			number += temp.data;
			temp = temp.next;
		}

		double decimalNum = 0;

		for(int i =0;i< number.length();i++){
			int bin = (number.charAt(i) == '1')?1:0;
			decimalNum = decimalNum + bin * Math.pow(2, (number.length() - i));
		}
		
		long result = (long) decimalNum;
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode one = new ListNode(0);
		ListNode one1 = new ListNode(0);
		ListNode one2 = new ListNode(1);
		ListNode one3 = new ListNode(1);
		ListNode one4 = new ListNode(0);
		ListNode one5 = new ListNode(1);
		ListNode one6 = new ListNode(0);
		
		ListNode head = one;
		
		one.next = one1;
		one1.next = one2;
		one2.next = one3;
		one3.next = one4;
		one4.next = one5;
		one5.next = one6;
		one6.next = null;
		
		long result =  LinkedListBinaryToDec.TestMyCode(head);
		System.out.println(result);

	}

}
