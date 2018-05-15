class Goose extends Duck{
    public Goose(String name){
	this.name = name;
	this.cname = "Goose";
	this.id = hashCode();
    }
    public String honk(){
    System.out.println("Honk! Honk!");
    return "Honk! Honk!";
    }

}