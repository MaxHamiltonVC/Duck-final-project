public class DuckApp{
public static void main(String[] args){
	MallardDuck mally = new MallardDuck("Mally");
	System.out.println("Testing mallard duck behavior: Swimming:\n");
	mally.swim();
	System.out.println("Testing mallard duck behavior: Printing:\n");
	System.out.println(mally);
	System.out.println("Testing mallard duck behavior: Quacking:\n");
	mally.quack();
	System.out.println("Testing redhead duck behavior: Flying:\n");
	mally.fly();
	
	RedheadDuck reddy = new RedheadDuck("Reddy");
	System.out.println("Testing redhead duck behavior: Swimming:\n");
	reddy.swim();
	System.out.println("Testing redhead duck behavior: Printing:\n");
	System.out.println(mally);
	System.out.println("Testing redhead duck behavior: Quacking:\n");
	reddy.quack();
	System.out.println("Testing redhead duck behavior: Flying:\n");
	reddy.fly();

	RubberDuck rubbery = new RubberDuck("Rubbery");
	System.out.println("Testing RubberDuck behavior: Swimming:\n");
	rubbery.swim();
	System.out.println("Testing RubberDuck behavior: Printing:\n");
	System.out.println(rubbery);
	System.out.println("Testing RubberDuck behavior: Quacking:\n");
	rubbery.quack();
	System.out.println("Testing RubberDuck behavior: Flying:\n");
	rubbery.fly();
	
	RubberDuck decoy = new RubberDuck("Decoy");
	System.out.println("Testing DecoyDuck behavior: Swimming:\n");
	decoy.swim();
	System.out.println("Testing DecoyDuck behavior: Printing:\n");
	System.out.println(decoy);
	System.out.println("Testing DecoyDuck behavior: Quacking:\n");
	decoy.quack();
	System.out.println("Testing DecoyDuck behavior: Flying:\n");
	decoy.fly();
	
		
	ModelDuck model = new ModelDuck("Modely");
	System.out.println("Testing ModelDuck behavior: Swimming:\n");
	model.swim();
	System.out.println("Testing ModelDuck behavior: Printing:\n");
	System.out.println(decoy);
	System.out.println("Testing ModelDuck behavior: Quacking:\n");
	model.quack();
	System.out.println("Testing ModelDuck behavior: Flying:\n");
	model.fly();
	System.out.println("Testing ModelDuck behavior: Changing fly mode and flying:\n");
	model.setFlyMode("like a swan!");
	model.fly();
}}
