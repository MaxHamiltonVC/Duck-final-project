/**
 * Created by mhamilton on 5/8/18.
 */
public interface ProgramState {
    public void takeUserInput();
    public void interpretUserInput(String userInput);
    //Interactive states:
    public void feed(int foodAmount);
    public void play(int playTime);
    public void educate();
    public void clean(int cleanTime);
    public void sleep(int sleepTime);
    public void scold();

    //Naming/creation states:
    public void setName(String duckName);
    public void setType(String duckType); //change to ENUM type?

    //Post-game-end states:
    public void exit();
    public void restart();
    public enumState getNextState();
}
