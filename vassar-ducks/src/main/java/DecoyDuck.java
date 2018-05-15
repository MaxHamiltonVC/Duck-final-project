
class DecoyDuck extends Duck{
    /**
    * Constructor. Creates a new duck with name equal to name.
    * @param name A string representing the name of this new duck.
    */
    public DecoyDuck(String name){
	this.name = name;
	this.cname = "DecoyDuck";
	this.id = hashCode();
    }
}
