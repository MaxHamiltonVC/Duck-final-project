
public class RubberDuck extends Duck implements CanQuack{ 
    public static void main(String[] args){
	
    }
    /**
    * Constructor. Creates a new duck with name equal to name.
    * @param name A string representing the name of this new duck.
    */
    public RubberDuck(String name){
	this.name = name;
	this.cname = "RubberDuck";
    }
    /**
	* Does nothing. Rubber ducks cannot fly.
	*/
	public String quack(){
	return quackNormal();
	}
}
