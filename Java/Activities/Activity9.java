package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {

	public static void main(String[]args) {
	List<String> myList=new ArrayList<>();
	myList.add("Ram");
	myList.add("sita");
	myList.add("sham");
	myList.add("vijay");
	myList.add("rahul");
	for(String sg:myList) {
		System.out.println(sg);
	}
	System.out.println(myList.get(2));
	if(myList.contains("Ram")) {
		System.out.println("true");
	}else {
		System.out.println("false");
	}
	System.out.println(myList.size());
	myList.remove(4);
	System.out.println(myList.size());
	}
	
	
}
