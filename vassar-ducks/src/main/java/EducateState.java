/**
 * Created by mhamilton on 5/8/18.
 */
public class EducateState implements ProgramState{
    Duck programDuck;
    inputInterpreter interpreter = inputInterpreter.getInstance();
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    enumState nextState = enumState.EDUCATE;
    public EducateState(Duck duck){
        programDuck = duck;
    }
    public void interpretUserInput(String userInput){}
    public void takeUserInput(){}

    public void feed(int foodAmount){}
    public void play(int playTime){}
    public void educate(){}
    public void clean(int cleanTime){}
    public void sleep(int sleepTime){}
    public void scold(){}

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
