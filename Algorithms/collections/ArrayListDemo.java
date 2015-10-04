import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {
	
	public static void main (String args[]){
		
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("a");
		al.add("b");
		al.add("c");
		al.add(1, "a1");
		
		System.out.println("Contents of ArrayList :" + al);
		
		al.remove("c");
		
		System.out.println("Modified contents of Array:" + al);
		
		/*multiple ways of iterating over ArrayList */
		
		for (int i =0;i < al.size();i++){			
			System.out.println(al.get(i));
		}
		System.out.println("Another");
		for (String temp : al){
			System.out.println(temp);		
		}
		
		System.out.println("Iterator");
		
		Iterator<String> itr = al.iterator();
		while(itr.hasNext()){			
			System.out.println(itr.next());
		}
		
	}
}
