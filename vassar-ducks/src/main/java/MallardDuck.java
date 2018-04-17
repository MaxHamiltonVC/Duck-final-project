
public class MallardDuck extends Duck implements CanFly,CanQuack{ 
    public static void main(String[] args){
	
    }
    /**
    * Constructor. Creates a new duck with name equal to name.
    * @param name A string representing the name of this new duck.
    */
    public MallardDuck(String name){
	this.name = name;
	this.cname = "MallardDuck";
    }
    public String fly(){
    return flyNormal();
    }
    public String quack(){
    	return quackNormal();
    }
}
