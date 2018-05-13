/**
 * Created by mhamilton on 5/8/18.
 */
public class NameState implements ProgramState {
    Duck programDuck;
    inputInterpreter interpreter = inputInterpreter.getInstance();
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    enumState nextState = enumState.NAME;
    public NameState(Duck duck){
        programDuck = duck;
    }
    public void interpretUserInput(String userInput){}
    public void takeUserInput(){}

    public void feed(int foodAmount){
        System.out.println("You should name your duck before you try to do that.");
    }
    public void play(int playTime){
        System.out.println("You should name your duck before you try to do that.");}
    public void educate(){
        System.out.println("You should name your duck before you try to do that.");}
    public void clean(){
        System.out.println("You should name your duck before you try to do that.");}
    public void sleep(int sleepTime){
        System.out.println("You should name your duck before you try to do that.");}
    public void scold(){
        System.out.println("You should name your duck before you try to do that.");}

    //Naming/creation states:
    public void setName(String duckName){
        programDuck.setName(duckName);
        System.out.println("Done! Your duck's name is now "+duckName+".");
        nextState = enumState.MAIN;
    }
    public void setType(String duckType){} //change to ENUM type?

    //Post-game-end states:
    public void exit(){
        System.out.println("Exiting the duck parenting simulator...");
        nextState = enumState.EXIT;}
    public void restart(){}

    public enumState getNextState(){
        return nextState;
    }
}
