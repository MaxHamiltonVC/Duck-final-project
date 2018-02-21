public class DuckApp{
public static void main(String[] args){
	MallardDuck mally = new MallardDuck("Mally");
	System.out.println("Testing mallard duck behavior: Swimming:\n");
	mally.swim();
	System.out.println("Testing mallard duck behavior: Printing:\n");
	System.out.println(mally);
	System.out.println("Testing mallard duck behavior: Quacking:\n");
	mally.quack();
	
	RedheadDuck reddy = new MallardDuck("Reddy");
	System.out.println("Testing redhead duck behavior: Swimming:\n");
	reddy.swim();
	System.out.println("Testing redhead duck behavior: Printing:\n");
	System.out.println(mally);
	System.out.println("Testing redhead duck behavior: Quacking:\n");
	reddy.quack();
}
}