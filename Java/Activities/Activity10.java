package activities;

import java.util.HashSet;
import java.util.Iterator;

public class Activity10 {
	public static void main(String[]args) {
		HashSet<String> hs=new HashSet<>();
		hs.add("a");
		hs.add("b");
		hs.add("c");
		hs.add("d");
		hs.add("e");
		hs.add("f");
		System.out.println(hs.size());
		hs.remove(1);
		if(hs.remove(0)) {
			System.out.println("o is removed from set");
		}else {
			System.out.println("o is not present in set");
		}
		if(hs.contains("d")) {
			System.out.println("set contain d");
		}else {
			System.out.println("set does not contain d");
		}
		Iterator<String> itr=hs.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
			
		}
		
	}

}
