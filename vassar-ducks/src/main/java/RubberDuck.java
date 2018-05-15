
public class RubberDuck extends Duck implements CanQuack{
    /**
    * Constructor. Creates a new duck with name equal to name.
    * @param name A string representing the name of this new duck.
    */
    public RubberDuck(String name){
	this.name = name;
	this.cname = "RubberDuck";
	this.id = hashCode();
    }
    /**
	* Does nothing. Rubber ducks cannot fly.
	*/
	public String quack(){
	return quackNormal();
	}
}
