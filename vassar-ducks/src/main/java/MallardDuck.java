
public class MallardDuck extends Duck implements CanFly,CanQuack{
    /**
    * Constructor. Creates a new duck with name equal to name.
    * @param name A string representing the name of this new duck.
    */
    public MallardDuck(String name){
	this.name = name;
	this.cname = "MallardDuck";
	this.id = hashCode();
    }
    public String fly(){
    return flyNormal();
    }
    public String quack(){
    	return quackNormal();
    }
}
