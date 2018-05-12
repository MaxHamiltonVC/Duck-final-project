import java.util.*;
public class Duck extends DuckExperience {
    protected String name = "";
    protected String cname = "Duck";
    protected int length = 1;
    protected int id = 0;
    protected int sleepiness = 0; // if it gets to 100, game over
    protected int hunger = 0; // if it gets to 100, game over
    protected int intelligence = 0; // a desirable characteristic
    protected int ego = 50; // if it gets to 100 or 0, game over
    
    public static void main(String[] args){
	
    }

    public int getEgo() {
        return ego;
    }

    public int getHunger() {
        return hunger;
    }

    public int getSleepiness() {
        return sleepiness;
    }

    public int getIntelligence() {
        return intelligence;
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
    
    public void setLength(int newlength){
    length = newlength;
    }
    
    public int getLength(){
    	return length;
    }
    /**
    * Returns a string representation of the duck. Used for printing, etc.
    * @return A string representing a statement of existence of this duck.
    */
    public String toString(){
    return "I am a "+cname+". My name is " + name;
    }
    class SortByLength implements Comparator<Duck>{
    public int compare(Duck a, Duck b){
    	if(a.getLength()<b.getLength()) return -1;
    	if(a.getLength()>b.getLength()) return 1;
    	else return 0;
    }
    }

    
}
