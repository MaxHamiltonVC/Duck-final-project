/**
 * Created by mhamilton on 5/8/18.
 */
public class ScoldState implements ProgramState {
    Duck programDuck;
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    enumState nextState = enumState.SCOLD;
    public ScoldState(Duck duck){
        programDuck = duck;
    }
    public void interpretUserInput(String userInput){}
    public void takeUserInput(){}

    public void feed(int foodAmount){}
    public void play(int playTime){}
    public void educate(){}
    public void clean(){}
    public void sleep(int sleepTime){}
    public void scold(){}

    //Naming/creation states:
    public void setName(String duckName){}
    public void setType(String duckType){} //change to ENUM type?

    //Post-game-end states:
    public void exit(){}
    public void restart(){}

    public enumState getNextState(){
        return nextState;
    }
}
