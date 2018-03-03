package duck.app;
public class ModelDuck extends Duck{ 
	private String mode = "";
    public static void main(String[] args){
	
    }
    /**
    * Constructor. Creates a new duck with name equal to name.
    * @param name A string representing the name of this new duck.
    */
    public ModelDuck(String name){
	this.name = name;
	this.cname = "ModelDuck";
    }
    public void setFlyMode(String mode){
    this.mode = mode;
    }
    public void fly(){
        System.out.println("I am "
			   +name+
			  " of the "+cname+" and I can fly " +mode);
    }

}
