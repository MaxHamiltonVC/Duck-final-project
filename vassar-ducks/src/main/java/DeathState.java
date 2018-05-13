/**
 * Created by mhamilton on 5/8/18.
 */
public class DeathState implements ProgramState{
    Duck programDuck;
    inputInterpreter interpreter = inputInterpreter.getInstance();
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    enumState nextState = enumState.DEATH;
    public DeathState(Duck duck){
        programDuck = duck;
    }
    public void interpretUserInput(String userInput){}
    public void takeUserInput(){}

    public void feed(int foodAmount){
        System.out.println(programDuck.getName() + " is dead. They can eat no longer.");
    }
    public void play(int playTime){
        System.out.println(programDuck.getName() + " is dead. They can play no longer.");}
    public void educate(){
        System.out.println(programDuck.getName() + " is dead. Their days of education are over.");}
    public void clean(){
        System.out.println(programDuck.getName() +
                " is dead. You clean them, but it doesn't bring them back.");}
    public void sleep(int sleepTime){
        System.out.println(programDuck.getName() + " is dead. They're sleeping forever now, in a way.");}
    public void scold(){
        System.out.println(programDuck.getName() + " is dead. Haven't they suffered enough?");}

    //Naming/creation states:
    public void setName(String duckName){}
    public void setType(String duckType){} //change to ENUM type?

    //Post-game-end states:
    public void exit(){
        System.out.println("Exiting the duck parenting simulator...");
        nextState = enumState.EXIT;}
    public void restart(){
        nextState = enumState.NAME;
        programDuck = new Duck();}

    public enumState getNextState(){
        return nextState;
    }
}
