/**
 * Created by mhamilton on 5/8/18.
 */
import java.util.Scanner;
public class MainState implements ProgramState {
    Duck programDuck;
    inputInterpreter interpreter = inputInterpreter.getInstance();
    Scanner inputGatherer = new Scanner(System.in);
    // this represents the next state of the program (ie, where we're transitioning to after user input)
    enumState nextState = enumState.MAIN;
    public MainState(Duck duck){
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
                System.out.println("Input not recognized. Type 'help' for a list of possible commands.");
                break;

        }
    }
    public void takeUserInput(){
        System.out.println("What would you like to do with your duck?");
        interpretUserInput(inputGatherer.next());
    }

    public void feed(int foodAmount){
        nextState = enumState.FEED;
    }
    public void play(int playTime){
        nextState = enumState.PLAY;
    }
    public void educate(){
        nextState = enumState.EDUCATE;
    }
    public void clean(int cleanTime){
        nextState = enumState.CLEAN;
    }
    public void sleep(int sleepTime){
        nextState = enumState.SLEEP;
    }
    public void scold(){
        nextState = enumState.SCOLD;
    }

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
    public void checkForDeath(){};
}

