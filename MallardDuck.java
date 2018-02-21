public class MallardDuck{
    String name = "";
    public static void main(String[] args){
	
    }
    /**
    * Constructor. Creates a new duck with name equal to name.
    * @param name A string representing the name of this new duck.
    */
    public MallardDuck(String name){
	this.name = name;
    }
    /**
    * Prints a message stating that the duck is swimming. Includes the name
    * of the duck.
    * @return void.
    */
    public void swim(){
       System.out.println("I am "
			   +name+
			  " of the MallardDuck class of ducks and I am swimming");
    }
    /**
    * Prints a message stating that the duck is quacking. Includes the name
    * of the duck.
    * @return void.
    */
	 public void quack(){
       System.out.println("Quack! Quack! Says "
			   +name+
			  " of the MallardDuck class of ducks");
    }
    /**
    * Returns a string representation of the duck. Used for printing, etc.
    * @return A string representing a statement of existence of this duck.
    */
    public String toString(){
    return "I am a MallardDuck. My name is " + name;
    }
}
