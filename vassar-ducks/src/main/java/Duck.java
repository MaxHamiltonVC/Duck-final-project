import java.util.*;
class Duck extends DuckExperience {
    String name = "your unnamed duck";
    String cname = "Duck";
    private int length = 1;
    int id = 0;
    private int sleepiness = 0; // if it gets to 100, game over
    private int hunger = 0; // if it gets to 100, game over
    private int intelligence = 0; // a desirable characteristic
    private int ego = 50; // if it gets to 100 or 0, game over
    private int cleanliness = 50; // if it gets to 0, game over
    private int happiness = 50; // if it gets to 0, game over

    public int getHappiness(){
        return happiness;
    }
    
    public int getCleanliness(){
        return cleanliness;
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

    public void setHappiness(int newHappiness){
        happiness = newHappiness;
    }
    
    public void setCleanliness(int newCleanliness){
        cleanliness = newCleanliness;
    }
    
    public void setEgo(int newEgo){
        ego = newEgo;
    }
    
    public void setHunger(int newHunger){
        hunger = newHunger;
    }

    public void setSleepiness(int newSleepiness){
        sleepiness = newSleepiness;
    }
    public void setIntelligence(int newIntelligence){
        intelligence = newIntelligence;
    }
    public String getName(){
        return name;
    }
    public void setName(String newName){
        name = newName;
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
    String quackNormal(){
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
    String flyNormal(){
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
    
    private int getLength(){
    	return length;
    }
    /**
    * Returns a string representation of the duck. Used for printing, etc.
    * @return A string representing a statement of existence of this duck.
    */
    public String toString(){
    return "I am a "+cname+". My name is " + name;
    }
    private class SortByLength implements Comparator<Duck>{
    public int compare(Duck a, Duck b){
    	if(a.getLength()<b.getLength()) return -1;
    	if(a.getLength()>b.getLength()) return 1;
    	else return 0;
    }
    }

    
}
