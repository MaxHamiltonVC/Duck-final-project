/**
 * Created by mhamilton on 5/8/18.
 */
public class CleanState implements ProgramState{
    Duck programDuck;
    inputInterpreter interpreter = inputInterpreter.getInstance();
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    enumState nextState = enumState.CLEAN;
    public CleanState(Duck duck){
        programDuck = duck;
    }
    public void interpretUserInput(String userInput){}
    public void takeUserInput(){}

    public void feed(int foodAmount){
        System.out.println(programDuck.getName() + "'s stench has made them lose their appetite.");
    }
    public void play(int playTime){
        System.out.println("Judging by how " + programDuck.getName() + " smells, I think they've had enough playtime.");
    }
    public void educate(){
        System.out.println("The only thing " + programDuck.getName() + " can think about is being cleaned.");
    }
    public void clean(){
        programDuck.setCleanliness(programDuck.getCleanliness() + 10);
        System.out.println(programDuck.getName() + " feels so much better!");
    }
    public void sleep(int sleepTime){
        System.out.println(programDuck.getName() + " doesn't want to sleep in their filth!");
    }
    public void scold(){
        System.out.println(programDuck.getName() + " can't hear you because their ears are COVERED in filth!");
    }

    //Naming/creation states:
    public void setName(String duckName){}
    public void setType(String duckType){} //change to ENUM type?

    //Post-game-end states:
    public void exit(){
        System.out.println("Exiting the duck parenting simulator...");
        nextState = enumState.EXIT;
    }
    public void restart(){
        nextState = enumState.NAME;
        programDuck = new Duck();}

    public enumState getNextState(){
        return nextState;
    }
}
