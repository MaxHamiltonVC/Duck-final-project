
public class Duck{
    protected String name = "";
    protected String cname = "Duck";
    public static void main(String[] args){
	
    }
    /**
    * Prints a message stating that the duck is swimming. Includes the name
    * of the duck.
    * @return void.
    */
    public String swim(){
       System.out.println("I am "
			   +name+
			  " of the "+cname+" class of ducks and I am swimming");
	return ("I am "
			   +name+
			  " of the "+cname+" class of ducks and I am swimming");
    }
    /**
    * Prints a message stating that the duck is quacking. Includes the name
    * of the duck.
    * @return void.
    */
	 public String quackNormal(){
       System.out.println("Quack! Quack! Says "
			   +name+
			  " of the "+cname+" class of ducks");
	return("Quack! Quack! Says "
			   +name+
			  " of the "+cname+" class of ducks");
    }
	/**
	* Prints a message saying that the duck is flying.
	*/
    public String flyNormal(){
    System.out.println("I am "
			   +name+
			  " of the "+cname+" and I can Fly!");
	return("I am "
			   +name+
			  " of the "+cname+" and I can Fly!");
    }
    /**
    * Returns a string representation of the duck. Used for printing, etc.
    * @return A string representing a statement of existence of this duck.
    */
    public String toString(){
    return "I am a "+cname+". My name is " + name;
    }
}
