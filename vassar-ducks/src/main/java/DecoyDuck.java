package duck.app;
public class DecoyDuck extends Duck{ 
    public static void main(String[] args){
	
    }
    /**
    * Constructor. Creates a new duck with name equal to name.
    * @param name A string representing the name of this new duck.
    */
    public DecoyDuck(String name){
	this.name = name;
	this.cname = "DecoyDuck";
    }
    /**
    * Does nothing. Decoy ducks can't fly.
	*/
	@Override
    public String fly(){
    	    // This does nothing. Decoy ducks cannot fly.
return "";
    }
    @Override
    public String quack(){
    	    // This does nothing. Decoy ducks cannot quack.
return "";
    }
}
