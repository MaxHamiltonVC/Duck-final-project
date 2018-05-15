/**
 * Created by mhamilton on 5/8/18.
 */
interface ProgramState {
    void takeUserInput();
    void interpretUserInput(String userInput);
    //Interactive states:
    void feed(int foodAmount);
    void play(int playTime);
    void educate();
    void clean(int cleanTime);
    void sleep(int sleepTime);
    void scold();

    //Naming/creation states:
    void setName(String duckName);
    void setType(String duckType); //change to ENUM type?

    //Post-game-end states:
    /**
     * Exits the duck app. This is done by setting the next state to EXIT, which by default has the behavior
     * of ending the loop in DuckApp.
     * @return void
     */
    void exit();
    void restart();

    /**
     * outputs the next state, which will either be the same as the current (if doing something over again),
     * or a new one, representing a transition to a different action.
     * @return enumState the next state of the program, as defined by enumState's guidelines
     */
    enumState getNextState();
    void checkForDeath();
}
