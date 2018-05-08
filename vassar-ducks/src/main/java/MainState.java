/**
 * Created by mhamilton on 5/8/18.
 */
public class MainState implements ProgramState {
    public void interpretUserInput(String userInput){}

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

}

