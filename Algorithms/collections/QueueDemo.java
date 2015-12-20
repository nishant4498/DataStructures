import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	
	public static void main(String[] args){
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		
		//Does not remove the element
		System.out.println(q.peek());
		
		System.out.println(q.poll());
		
		
		while(!q.isEmpty()){
			System.out.println(q.poll());
		}
	}

}
