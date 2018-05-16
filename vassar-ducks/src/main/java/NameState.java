import java.util.Scanner;

/**
 * Created by mhamilton on 5/8/18.
 */
public class NameState implements ProgramState {
    private Duck programDuck;
    private String duckName = "Ducky";
    private boolean unnamed = true;
    private final inputInterpreter interpreter = inputInterpreter.getInstance();
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    private enumState nextState = enumState.NAME;
    public NameState(Duck duck){
        programDuck = duck;
    }
    public void interpretUserInput(String userInput){
        enumUserAction processedInput = inputInterpreter.interpret(userInput);
        Scanner inputGatherer = new Scanner(System.in);
        switch(processedInput){
            case EDUCATE:
                educate();
                break;
            case SLEEP:
                sleep(0);
                break;
            case SCOLD:
                scold();
                break;
            case CLEAN:
                clean(0);
                break;
            case PLAY:
                play(0);
                break;
            case MAIN:
                nextState = enumState.MAIN;
                break;
            case FEED:
                feed(0);
                break;
            case EXIT:
                exit();
                break;
            case RESTART:
                System.out.println("Are you sure you want to restart the duck app with a whole new duck? "
                        + programDuck.getName()+" will be lost forever!");
                if(inputInterpreter.interpret(inputGatherer.next())==enumUserAction.YES){
                    System.out.println("Restarting the duck app! Say goodbye to "+programDuck.getName()+"...");
                    restart();
                }
                break;
            case HELP:
                System.out.println("Commands include: ");
                System.out.println("Educated, sleep, scold, clean, play, main, feed, exit, and restart.");
                break;
            default:
                setName(duckName);
                unnamed = false;
                break;

        }
    }
    public void takeUserInput(){
        System.out.println("Welcome to the duck parenting simulator. What would you like to name your duck?");
        Scanner inputGatherer = new Scanner(System.in);
        while(unnamed){
            duckName = inputGatherer.next();
            interpretUserInput(duckName);
        }
    }

    public void feed(int foodAmount){
        System.out.println("You should name your duck before you try to do that.");
    }
    /**
     * This will print a message telling the user that this is not the right time to play, because this state
     * is not one in which playing is allowed.
     * @param playTime the amount of time to play for.
     */
    public void play(int playTime){
        System.out.println("You should name your duck before you try to do that.");}
    public void educate(){
        System.out.println("You should name your duck before you try to do that.");}
    public void clean(int cleanTime){
        System.out.println("You should name your duck before you try to do that.");}
    public void sleep(int sleepTime){
        System.out.println("You should name your duck before you try to do that.");}
    /**
     * Prints a message informing the user that this is not a state in which the duck can be scolded.
     */
    public void scold(){
        System.out.println("You should name your duck before you try to do that.");}

    //Naming/creation states:

    /**
     * Changes the name of our duck.
     * @param duckName the new name for our duck to have.
     */
    public void setName(String duckName){
        programDuck.setName(duckName);
        System.out.println("Done! Your duck's name is now "+duckName+".");
        nextState = enumState.MAIN;
    }
    public void setType(String duckType){} //change to ENUM type?

    //Post-game-end states:
    /**
     * Exits the game. This is done by changing the next state to EXIT, which will end the loop in DuckApp.
     */
    public void exit(){
        System.out.println("Exiting the duck parenting simulator...");
        nextState = enumState.EXIT;}
    public void restart(){
        nextState = enumState.NAME;
        programDuck = new Duck();}

    /**
     * This returns our next state, so that DuckApp can figure out where to go next in its loop.
     * @return the next state, one of the states enumerated by enumState.
     */
    public enumState getNextState(){
        return nextState;
    }
    /**
     * Checks if the duck has died. The thing that could go wrong:
     * Duck is too dirty
     * Duck has too big or too small of an ego
     * Duck is too sleepy
     * Duck is too hungry
     * Duck is too unhappy
     */
    public void checkForDeath(){
        if(programDuck.getEgo()<0||programDuck.getEgo()>100||programDuck.getCleanliness()<0
                ||programDuck.getHappiness()<0||programDuck.getHunger()>100||programDuck.getSleepiness()>100){
            //these are all the conditions for the duck dying (as laid out in the duck class' comments)
            nextState = enumState.DEATH;
        }
    }
}
