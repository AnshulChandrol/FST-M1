package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
public static void main(String[]args) {
	Map<Integer, String> colours=new HashMap<>();
	colours.put(1, "red");
	colours.put(2, "white");
	colours.put(3, "pink");
	colours.put(4, "blue");
	colours.put(5, "black");
	colours.remove(2);
	if(colours.containsValue("green")) {
		System.out.println("map contains colour green");
	}else {
		System.out.println("map does not contain green colour");
	}
	System.out.println(colours.size());
}
}
