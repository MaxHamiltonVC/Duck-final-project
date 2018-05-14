import java.util.Scanner;

/**
 * Created by mhamilton on 5/8/18.
 */
public class NameState implements ProgramState {
    Duck programDuck;
    String duckName = "Ducky";
    boolean unnamed = true;
    inputInterpreter interpreter = inputInterpreter.getInstance();
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    enumState nextState = enumState.NAME;
    public NameState(Duck duck){
        programDuck = duck;
    }
    public void interpretUserInput(String userInput){
        enumUserAction processedInput = interpreter.interpret(userInput);
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
                if(interpreter.interpret(inputGatherer.next())==enumUserAction.YES){
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
    public void play(int playTime){
        System.out.println("You should name your duck before you try to do that.");}
    public void educate(){
        System.out.println("You should name your duck before you try to do that.");}
    public void clean(int cleanTime){
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
    public void restart(){
        nextState = enumState.NAME;
        programDuck = new Duck();}

    public enumState getNextState(){
        return nextState;
    }
}
