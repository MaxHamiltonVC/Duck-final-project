
public class ModelDuck extends Duck implements CanQuack{ 
	private String mode = "";

    /**
    * Constructor. Creates a new duck with name equal to name.
    * @param name A string representing the name of this new duck.
    */
    public ModelDuck(String name){
	this.name = name;
	this.cname = "ModelDuck";
	this.id = hashCode();
    }
    public void setFlyMode(String mode){
    this.mode = mode;
    }
    public String fly(){
        System.out.println("I am "
			   +name+
			  " of the "+cname+" and I can fly " +mode);
	return("I am "
			   +name+
			  " of the "+cname+" and I can fly " +mode);
    }
    public String quack(){
    	return quackNormal();
    }

}
