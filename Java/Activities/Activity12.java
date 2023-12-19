package activities;

public class Activity12 {
public static void main(String[]args) {
	//int ad1;
	Addable ad1=(int a,int b)->(a+b);
	System.out.println(ad1.add(10, 20));
	Addable ad2=(int a,int b)->{
		return (a+b);
	};
	System.out.println(ad2.add(100, 10));
	
}
}
