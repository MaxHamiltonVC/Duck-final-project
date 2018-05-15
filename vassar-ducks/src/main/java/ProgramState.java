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
    /**
     * Exits the duck app. This is done by setting the next state to EXIT, which by default has the behavior
     * of ending the loop in DuckApp.
     * @return void
     */
    public void exit();
    public void restart();

    /**
     * outputs the next state, which will either be the same as the current (if doing something over again),
     * or a new one, representing a transition to a different action.
     * @return enumState the next state of the program, as defined by enumState's guidelines
     */
    public enumState getNextState();
    public void checkForDeath();
}
